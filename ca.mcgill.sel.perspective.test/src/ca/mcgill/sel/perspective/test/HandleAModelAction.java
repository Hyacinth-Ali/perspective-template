package ca.mcgill.sel.perspective.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.amodel.AModel;
import ca.mcgill.sel.amodel.AmodelPackage;
import ca.mcgill.sel.amodel.controller.AModelController;
import ca.mcgill.sel.cmodel.CModel;
import ca.mcgill.sel.cmodel.CmodelPackage;
import ca.mcgill.sel.cmodel.controller.CModelController;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREScene;
import ca.mcgill.sel.ram.ui.perspective.FacadeAction;

public class HandleAModelAction {

	public static EObject createA1(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner,
			String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		AModel otherOwner = (AModel) owner;
		initialElements.addAll(otherOwner.getA1s());
		// primary language action to create a new class
		AModelController.getInstance().createA1(otherOwner, name);
		elements.addAll(otherOwner.getA1s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);

		return newElement;

	}

	public static EObject createA2(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner,
			String name) {

//		List<EObject> elements = new ArrayList<EObject>();
//		List<EObject> initialElements = new ArrayList<EObject>();
//		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
//		if (owner == null) {
//			return null;
//		}
//		AModel otherOwner = (AModel) owner;
//		initialElements.addAll(otherOwner.getA2s());
//		// primary language action to create a new class
//		AModelController.getInstance().createA2(otherOwner, name);
//		elements.addAll(otherOwner.getA2s());
//		elements.removeAll(initialElements);
//		EObject newElement = elements.get(0);
//		
//		return newElement;

		// Handle parameter mappings
		EObject o = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		AModel owner = (AModel) o;

		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		createSecondaryEffects.add(AmodelPackage.eINSTANCE.getA3());
		createSecondaryEffects.add(AmodelPackage.eINSTANCE.getA4());

		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, CmodelPackage.eINSTANCE.getC2());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);

		// primary language action to create a new class
		AModelController.getInstance().createA2(owner, name);

		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, AmodelPackage.eINSTANCE.getA2());

		// get other new elements for each language element
		Map<EObject, Collection<EObject>> after = ModelElementStatus.INSTANCE.getOtherNewElements(owner,
				createSecondaryEffects);

		HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, roleName, after, owner, name);

		return newElement;

	}

	public static EObject createA3(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner,
			String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		AModel otherOwner = (AModel) owner;
		initialElements.addAll(otherOwner.getA3s());
		// primary language action to create a new class
		AModelController.getInstance().createA3(otherOwner, name);
		elements.addAll(otherOwner.getA3s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);

		return newElement;

	}

	public static EObject createA4(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner,
			String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		AModel otherOwner = (AModel) owner;
		initialElements.addAll(otherOwner.getA4s());
		// primary language action to create a new class
		AModelController.getInstance().createA4(otherOwner, name);
		elements.addAll(otherOwner.getA4s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);

		return newElement;

	}

	public static EObject createA5(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner,
			String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		AModel otherOwner = (AModel) owner;
		initialElements.addAll(otherOwner.getA5s());
		// primary language action to create a new class
		AModelController.getInstance().createA5(otherOwner, name);
		elements.addAll(otherOwner.getA5s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);

		return newElement;

	}

	public static EObject createA6(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner,
			String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		AModel otherOwner = (AModel) owner;
		initialElements.addAll(otherOwner.getA6s());
		// primary language action to create a new class
		AModelController.getInstance().createA6(otherOwner, name);
		elements.addAll(otherOwner.getA6s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);

		return newElement;

	}

	public static EObject createA7(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner,
			String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		AModel otherOwner = (AModel) owner;
		initialElements.addAll(otherOwner.getA7s());
		// primary language action to create a new class
		AModelController.getInstance().createA7(otherOwner, name);
		elements.addAll(otherOwner.getA7s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);

		return newElement;

	}

	public static EObject createA8(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner,
			String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		AModel otherOwner = (AModel) owner;
		initialElements.addAll(otherOwner.getA8s());
		// primary language action to create a new class
		AModelController.getInstance().createA8(otherOwner, name);
		elements.addAll(otherOwner.getA8s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);

		return newElement;

	}

	public static EObject createA9(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner,
			String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		AModel otherOwner = (AModel) owner;
		initialElements.addAll(otherOwner.getA9s());
		// primary language action to create a new class
		AModelController.getInstance().createA9(otherOwner, name);
		elements.addAll(otherOwner.getA9s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);

		return newElement;

	}

	public static EObject createA10(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner,
			String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		AModel otherOwner = (AModel) owner;
		initialElements.addAll(otherOwner.getA10s());
		// primary language action to create a new class
		AModelController.getInstance().createA10(otherOwner, name);
		elements.addAll(otherOwner.getA10s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);

		return newElement;

	}

	public static EObject createA11(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner,
			String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		AModel otherOwner = (AModel) owner;
		initialElements.addAll(otherOwner.getA11s());
		// primary language action to create a new class
		AModelController.getInstance().createA11(otherOwner, name);
		elements.addAll(otherOwner.getA11s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);

		return newElement;

	}

	public static EObject createA12(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner,
			String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		AModel otherOwner = (AModel) owner;
		initialElements.addAll(otherOwner.getA12s());
		// primary language action to create a new class
		AModelController.getInstance().createA12(otherOwner, name);
		elements.addAll(otherOwner.getA12s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);

		return newElement;

	}

}
