/*
 * StatementList.java
 *
 * Created on August 22, 2006, 11:53 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.statementlist;

import genetic.*;
import genetic.component.statement.StatementFactory;
import genetic.component.statement.Statement;
import genetic.Foundation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gtg126z
 */
public class StatementList implements GeneticComponent {
    
    private static final int numberBaseStatements = 1;
    private static final int numberFlexStatements = 3;
    
    private ContextModel contextModel;
    private List<Statement> statements;
    private GeneticComponent parent;
    
    /** Creates a new instance of StatementList */
    protected StatementList() {
        statements = new ArrayList<Statement>();
    }
    
    public StatementList(GeneticComponent parent) {
        this.parent = parent;
        statements = new ArrayList<Statement>();
        
        //boolean newVars = Math.random() < .1f;
        contextModel = new ContextModel(parent.getContextModel());
        
        StatementFactory factory = Foundation.getInstance().getStatementFactory();
        
        int numberStatements = Foundation.getInstance().getBuilderRandom().
                nextInt(numberFlexStatements) + numberBaseStatements;
        for(int i=0;i<numberStatements;i++) {
            Statement statement = factory.createStatement(this);
            statements.add(statement);
        }
    }
    
    public void resetParent(GeneticComponent newParent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public GeneticComponent getParent() {
        return parent;
    }

    public ContextModel getContextModel() {
        return contextModel;
    }

    /*public void mutate() {
        //return null; // FIXME
        
        if(Math.random() < .1f && contextModel.getMyVariables().size() > 0) {
            int toRemove = new Random().nextInt( Math.min(contextModel.getMyVariables().size(), 3) );
            for(int i=0;i<toRemove;i++) {
                String varName = contextModel.getMyVariables().get( new Random().nextInt(contextModel.getMyVariables().size()) );
                removeVariable(varName);
                contextModel.removeVariable(varName);
            }
        }
        if(Math.random() < .05f)
            contextModel.createNewVariables();
        
        if(Math.random() < .75f && statements.size() > 0) {
            
            int index = new Random().nextInt(statements.size());
            statements.get(index).mutate();
            
            return;
        }
        
        boolean mutated = false;
        while(!mutated) {
            switch(new Random().nextInt(10)) {
                case 0: mutated = mutateAddStatement(); break;
                case 1: mutated = mutateRemoveStatement(); break;
                case 2: mutated = mutateRemoveStatement(); break;
                case 3: mutated = mutateRemoveStatement(); break;
                case 4: mutated = mutateCollapseConditionalLeft(); break;
                case 5: mutated = mutateCollapseConditionalRight(); break;
                case 6: mutated = mutateCollapseConditionalLeft(); break;
                case 7: mutated = mutateCollapseConditionalRight(); break;
                case 8: mutated = mutateAddConditional1(); break;
                case 9: mutated = mutateAddConditional2(); break;
            }
        }
    }

    public GeneticComponent breed(GeneticComponent component) {
        StatementList mate = (StatementList) component;
        
        return null; // FIXME
    }*/
    
    public StatementList clone(GeneticComponent newParent) {
        StatementList r = new StatementList();
        
        r.parent = newParent;
        r.contextModel = contextModel.clone();
        r.contextModel.setParent(newParent.getContextModel());
        for(Statement statement : statements) {
            r.statements.add(statement.clone(r));
        }
        return r;
    }
    
    public void execute(Context parentContext) {
        Context context = contextModel.createContext(parentContext);
        for(Statement statement : statements) {
            try{
                statement.execute(context);
            }
            catch(NullPointerException e) {handleExecutionException(e,statement,context);}
            catch(ClassCastException e) {handleExecutionException(e,statement,context);}
        }
    }
    
    private void handleExecutionException(RuntimeException e, Statement statement, Context context) {
        System.out.flush();
        System.err.flush();

        System.err.println(statement);
        for(String var : contextModel.getVariables()) {
            System.err.println("    "+contextModel.getType(var)+": var."+var+" = "+context.getVariable(var));
        }
        throw e;
    }

    public String printout(String indent) {
        String r = indent + "statementList\n";
        r += contextModel.printout(indent+"  ");
        for(Statement statement : statements) {
            r += statement.printout(indent+"  ");
        }
        return r;
    }

    /*protected boolean mutateAddStatement() {
        
        StatementFactory factory = new StatementFactory(contextModel);
        Statement statement = factory.createStatement(this);
        if(statements.size() > 0)
            statements.add(new Random().nextInt(statements.size()+1),statement);
        else
            statements.add(statement);
        return true;
    }

    protected boolean mutateRemoveStatement() {
        if(statements.size() == 0)
            return false;
        
        int index = new Random().nextInt(statements.size());
        statements.remove(index);
        return true;
    }

    protected boolean mutateCollapseConditionalLeft() {
        List<ConditionalStatement> conditionals = new ArrayList();
        for(Statement statement : statements)
            if(statement instanceof ConditionalStatement)
                conditionals.add((ConditionalStatement)statement);
        
        if(conditionals.size() == 0)
            return false;
        
        int index = new Random().nextInt(conditionals.size());
        ConditionalStatement conditional = conditionals.get(index);
        
        int insertLocation = statements.indexOf(conditional);
        statements.remove(conditional);
        contextModel.absorb(conditional.getIfBody().contextModel);
        statements.addAll(insertLocation, conditional.getIfBody().statements);
        return true;
    }

    protected boolean mutateCollapseConditionalRight() {
        List<ConditionalStatement> conditionals = new ArrayList();
        for(Statement statement : statements)
            if(statement instanceof ConditionalStatement)
                conditionals.add((ConditionalStatement)statement);
        
        if(conditionals.size() == 0)
            return false;
        
        int index = new Random().nextInt(conditionals.size());
        ConditionalStatement conditional = conditionals.get(index);
        
        int insertLocation = statements.indexOf(conditional);
        statements.remove(conditional);
        contextModel.absorb(conditional.getElseBody().contextModel);
        statements.addAll(insertLocation, conditional.getElseBody().statements);
        return true;
    }

    protected boolean mutateAddConditional1() {
        
        if(statements.size() == 0)
            return false;
        
        int index = new Random().nextInt(statements.size());
        int span = new Random().nextInt( Math.min(statements.size() - index, 3) );
        List<Statement> ifBody = new ArrayList(statements.subList(index,index+span));
        
        ConditionalStatement conditional;
        try {
            conditional = new ConditionalStatement(this);
        } catch (StatementConstructionException ex) {
            return false;
        }
        statements.removeAll(ifBody);
        conditional.getIfBody().statements = ifBody;
        conditional.getElseBody().statements = Collections.emptyList();
        statements.add(index, conditional);
        return true;
    }

    protected boolean mutateAddConditional2() {
        
        if(statements.size() == 0)
            return false;
        
        int index = new Random().nextInt(statements.size());
        int span = new Random().nextInt( Math.min(statements.size() - index, 3) );
        List<Statement> ifBody = new ArrayList(statements.subList(index,index+span));
        
        ConditionalStatement conditional;
        try {
            conditional = new ConditionalStatement(this);
        } catch (StatementConstructionException ex) {
            return false;
        }
        statements.removeAll(ifBody);
        conditional.getIfBody().statements = ifBody;
        statements.add(index, conditional);
        return true;
    }*/

    public void removeVariable(String name) {
        List<Statement> toRemove = new ArrayList();
        for(Statement statement : statements) {
            statement.removeVariable(name);
            if(statement.isDestroyFlagged())
                toRemove.add(statement);
        }
        statements.removeAll(toRemove);
    }
}
