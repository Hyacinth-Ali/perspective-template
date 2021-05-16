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

public class HandleCModelAction {
	
	public static EObject createC1(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner, String name) {

		List<EObject> elements = new ArrayList<EObject>();
		List<EObject> initialElements = new ArrayList<EObject>();
		EObject owner = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		if (owner == null) {
			return null;
		}
		CModel otherOwner = (CModel) owner;
		initialElements.addAll(otherOwner.getC1s());
		// primary language action to create a new class
		CModelController.getInstance().createC1(otherOwner, name);
		elements.addAll(otherOwner.getC1s());
		elements.removeAll(initialElements);
		EObject newElement = elements.get(0);
		
		return newElement;

	}
	
	public static EObject createC2(COREPerspective perspective, COREScene scene, String roleName, EObject currentOwner, String name) {

		// Handle parameter mappings
		EObject o = FacadeAction.getOwner(perspective, scene, currentOwner, roleName);
		CModel owner = (CModel) o;
		
		List<EObject> createSecondaryEffects = new ArrayList<EObject>();
		createSecondaryEffects.add(CmodelPackage.eINSTANCE.getC1());
		
		// record existing elements.
		ModelElementStatus.INSTANCE.setMainExistingElements(owner, CmodelPackage.eINSTANCE.getC2());
		ModelElementStatus.INSTANCE.setOtherExistingElements(owner, createSecondaryEffects);
		
		// primary language action to create a new class
		CModelController.getInstance().createC2(owner, name);
		
		// retrieve the new element
		EObject newElement = ModelElementStatus.INSTANCE.getNewElement(owner, CmodelPackage.eINSTANCE.getC2());
		
		// get other new elements for each language element
		Map<EObject, Collection<EObject>> after = ModelElementStatus.INSTANCE.getOtherNewElements(owner, createSecondaryEffects);
		
		HandleSecondaryEffect.INSTANCE.createSecondaryEffects(perspective, scene, roleName, after, 
			owner, name);
		
		return newElement;

	}

}
