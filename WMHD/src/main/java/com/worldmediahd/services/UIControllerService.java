package com.worldmediahd.services;

/**
 * UIController interface. All the very basic actions are meant to be here. If
 * you need extra 'uncommon' actions, either extend this interface, or extend
 * the GenericUIControllerServiceImpl. 
 * 
 * NB: Preferable choice is to extend this
 * implementation and write your own service. Then write your own binding module
 * and create an Injector from there.
 * 
 * @author Mo
 */
public interface UIControllerService {
	public void buttonClicked();
}
