/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.painter.geneticsupport.app;

import genetic.GeneticTopLevel;
import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

/**
 *
 * @author Calvin Ashmore
 */
public class ApplicationInstance implements Lookup.Provider, ProgramProvider {
    private static ApplicationInstance instance = new ApplicationInstance();

    public static ApplicationInstance getInstance() {
        return instance;
    }
    private InstanceContent ic;
    private Lookup lookup;
    
    private GeneticTopLevel program;

    public ApplicationInstance() {
        ic = new InstanceContent();
        lookup = new AbstractLookup(ic);
    }

    public Lookup getLookup() {
        return lookup;
    }
    
    public void setProgram(GeneticTopLevel program) {
        this.program = program;
        for(ProgramListener listener : lookup.lookupAll(ProgramListener.class))
            listener.onProgramChange(program);
    }

    public void addProgramListener(ProgramListener listener) {
        ic.add(listener);
    }

    public GeneticTopLevel getProgram() {
        return program;
    }
}
