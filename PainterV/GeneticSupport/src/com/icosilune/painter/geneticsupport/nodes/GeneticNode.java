/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icosilune.painter.geneticsupport.nodes;

import genetic.GeneticComponent;
import java.util.List;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Calvin Ashmore
 */
abstract public class GeneticNode<T extends GeneticComponent> extends AbstractNode {

    private T component;

    public GeneticNode(T component) {
        super(new GeneticNodeChildren(), Lookups.singleton(component));
        ((GeneticNodeChildren<T>) getChildren()).node = this;
        this.component = component;
    }

    protected T getComponent() {
        return component;
    }

    abstract protected Node createNode(Object obj);
    abstract protected List<Object> getGeneticChildren();

    private static class GeneticNodeChildren<T> extends Children.Keys implements ChangeListener {

        private GeneticNode node;

        public GeneticNodeChildren() {
        }

        @Override
        protected Node[] createNodes(Object key) {
            return new Node[] {node.createNode(key)};
        }

        @Override
        protected void addNotify() {
            //super.addNotify();
            setKeys(node.getGeneticChildren());
        }
        
        public void stateChanged(ChangeEvent e) {
            setKeys(node.getGeneticChildren());
        }
    }
}
