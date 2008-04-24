/*
 * StatementList.java
 *
 * Created on August 22, 2006, 11:53 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package genetic.component.statementlist;

import genetic.component.context.Context;
import genetic.component.context.ContextModel;
import genetic.GeneticComponent;
import genetic.*;
import genetic.component.statement.Statement;
import genetic.Foundation;
import genetic.BuildException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author gtg126z
 */
public class StatementList implements GeneticComponent {
    
    private ContextModel contextModel;
    private List<Statement> statements;
    private GeneticComponent parent;
    
    private boolean isSetup;
    
    public StatementList(GeneticComponent parent) {
        this.parent = parent;

        contextModel = new ContextModel(parent.getContextModel());
    }

    public List<Statement> getStatements() {
        return Collections.unmodifiableList(statements);
    }
    
    public boolean isSetup() {
        return isSetup;
    }

    public void setStatements(Statement... newStatements) {
        statements = new ArrayList<Statement>();
        
        for(Statement statement : newStatements) {
            statements.add(statement);
        }
    }
    
    /**
     * Setup will build the list of statements for this StatementList if they are null.
     * @throws genetic.BuildException
     */
    public void setup() throws BuildException {
        
        if(statements == null) {
            statements = Foundation.getInstance().getStatementListBuilder().buildChildren(this);
            /*statements = new ArrayList<Statement>();

            StatementBuilder builder = Foundation.getInstance().getStatementBuilder();

            int numberStatements = Foundation.getInstance().getBuilderRandom().
                    nextInt(numberFlexStatements) + numberBaseStatements;

            for(int i=0;i<numberStatements;i++) {
                Statement statement = builder.buildStatement(this);
                statements.add(statement);
                //Statement statementTemplate = factory.select(contextModel, false);
                //Statement statement = factory.build(statementTemplate.getClass(), contextModel);
                //statements.add(statement);
            }*/
        }
        
        for(Statement statement : statements)
            if(!statement.isSetup())
                statement.setup();
        
        isSetup = true;
    }
    
    public void setParent(GeneticComponent newParent) {
        this.parent = newParent;
    }

    public GeneticComponent getParent() {
        return parent;
    }

    public ContextModel getContextModel() {
        return contextModel;
    }
    
    public StatementList clone(GeneticComponent newParent) throws BuildException {
        StatementList clone = new StatementList(newParent);
        
        clone.parent = newParent;
        clone.contextModel = contextModel.copy();
        clone.contextModel.setParent(newParent.getContextModel());
        for(Statement statement : statements) {
            clone.statements.add(statement.clone(clone));
        }
        
        clone.isSetup = true;
        //r.setup();
        
        return clone;
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

    public boolean hasVariable(String name) {
        for(Statement statement : statements) {
            if(statement.hasVariable(name))
                return true;
        }
        return false;
    }

    public boolean hasMethod(String name) {
        for(Statement statement : statements) {
            if(statement.hasMethod(name))
                return true;
        }
        return false;
    }
}
