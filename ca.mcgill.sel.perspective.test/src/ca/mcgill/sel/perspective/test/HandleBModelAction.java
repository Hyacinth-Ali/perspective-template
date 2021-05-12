package ca.mcgill.sel.perspective.test;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.bmodel.BModel;
import ca.mcgill.sel.bmodel.controller.BModelController;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREScene;
import ca.mcgill.sel.ram.ui.perspective.FacadeAction;

public class HandleBModelAction {
	
	public static EObject createB1(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner, String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		BModel otherOwner = (BModel) owner;
		initialElements.addAll(otherOwner.getB1s());
		// primary language action to create a new class
		BModelController.getInstance().createB1(otherOwner, name);
		elements.addAll(otherOwner.getB1s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);
		
		return newElement;

	}
	
	public static EObject createB2(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner, String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		BModel otherOwner = (BModel) owner;
		initialElements.addAll(otherOwner.getB2s());
		// primary language action to create a new class
		BModelController.getInstance().createB2(otherOwner, name);
		elements.addAll(otherOwner.getB2s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);
		
		return newElement;

	}
	
	public static EObject createB3(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner, String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		BModel otherOwner = (BModel) owner;
		initialElements.addAll(otherOwner.getB3s());
		// primary language action to create a new class
		BModelController.getInstance().createB3(otherOwner, name);
		elements.addAll(otherOwner.getB3s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);
		
		return newElement;

	}
	
	public static EObject createB4(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner, String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		BModel otherOwner = (BModel) owner;
		initialElements.addAll(otherOwner.getB4s());
		// primary language action to create a new class
		BModelController.getInstance().createB4(otherOwner, name);
		elements.addAll(otherOwner.getB4s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);
		
		return newElement;

	}
	
	public static EObject createB5(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner, String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		BModel otherOwner = (BModel) owner;
		initialElements.addAll(otherOwner.getB5s());
		// primary language action to create a new class
		BModelController.getInstance().createB5(otherOwner, name);
		elements.addAll(otherOwner.getB5s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);
		
		return newElement;

	}
	
	public static EObject createB6(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner, String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		BModel otherOwner = (BModel) owner;
		initialElements.addAll(otherOwner.getB6s());
		// primary language action to create a new class
		BModelController.getInstance().createB6(otherOwner, name);
		elements.addAll(otherOwner.getB6s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);
		
		return newElement;

	}
	
	public static EObject createB7(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner, String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		BModel otherOwner = (BModel) owner;
		initialElements.addAll(otherOwner.getB7s());
		// primary language action to create a new class
		BModelController.getInstance().createB7(otherOwner, name);
		elements.addAll(otherOwner.getB7s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);
		
		return newElement;

	}
	
	public static EObject createB8(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner, String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		BModel otherOwner = (BModel) owner;
		initialElements.addAll(otherOwner.getB8s());
		// primary language action to create a new class
		BModelController.getInstance().createB8(otherOwner, name);
		elements.addAll(otherOwner.getB8s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);
		
		return newElement;

	}
	
	public static EObject createB9(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner, String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		BModel otherOwner = (BModel) owner;
		initialElements.addAll(otherOwner.getB9s());
		// primary language action to create a new class
		BModelController.getInstance().createB9(otherOwner, name);
		elements.addAll(otherOwner.getB9s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);
		
		return newElement;

	}
	
	public static EObject createB10(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner, String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		BModel otherOwner = (BModel) owner;
		initialElements.addAll(otherOwner.getB10s());
		// primary language action to create a new class
		BModelController.getInstance().createB10(otherOwner, name);
		elements.addAll(otherOwner.getB10s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);
		
		return newElement;

	}
	
	public static EObject createB11(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner, String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		BModel otherOwner = (BModel) owner;
		initialElements.addAll(otherOwner.getB11s());
		// primary language action to create a new class
		BModelController.getInstance().createB11(otherOwner, name);
		elements.addAll(otherOwner.getB11s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);
		
		return newElement;

	}
	
	public static EObject createB12(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner, String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		BModel otherOwner = (BModel) owner;
		initialElements.addAll(otherOwner.getB12s());
		// primary language action to create a new class
		BModelController.getInstance().createB12(otherOwner, name);
		elements.addAll(otherOwner.getB12s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);
		
		return newElement;

	}

}
