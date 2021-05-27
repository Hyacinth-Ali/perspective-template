package ca.mcgill.sel.perspective.testfonduemapping;

import java.util.List;
import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.core.*;
import ca.mcgill.sel.core.perspective.COREPerspectiveUtil;

import ca.mcgill.sel.amodel.*;
import ca.mcgill.sel.bmodel.*;
import ca.mcgill.sel.cmodel.*;
import ca.mcgill.sel.amodel.controller.*;
import ca.mcgill.sel.bmodel.controller.*;
import ca.mcgill.sel.cmodel.controller.*;

public class AModelFacadeAction {
	public static EObject createOtherElementsForA2(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(CmodelPackage.eINSTANCE.getC2())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			CModel otherOwner = (CModel) o;
			newElement = RedefinedCModelAction.createNewC2(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForA3(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(BmodelPackage.eINSTANCE.getB3())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			BModel otherOwner = (BModel) o;
			newElement = RedefinedBModelAction.createNewB3(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForA4(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(BmodelPackage.eINSTANCE.getB1())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			BModel otherOwner = (BModel) o;
			newElement = RedefinedBModelAction.createNewB1(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		else if (otherLE.equals(CmodelPackage.eINSTANCE.getC1())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			CModel otherOwner = (CModel) o;
			newElement = RedefinedCModelAction.createNewC1(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static void deleteModelElement(COREPerspective perspective, COREScene scene, String otherRoleName, EObject otherElement) {
		if (otherElement instanceof A2) {
			RedefinedAModelAction.deleteA2(perspective, scene, otherRoleName, otherElement);
		}
		else if (otherElement instanceof A3) {
			RedefinedAModelAction.deleteA3(perspective, scene, otherRoleName, otherElement);
		}
		else if (otherElement instanceof A4) {
			RedefinedAModelAction.deleteA4(perspective, scene, otherRoleName, otherElement);
		}
		else if (otherElement instanceof B1) {
			RedefinedBModelAction.deleteB1(perspective, scene, otherRoleName, otherElement);
		}
		else if (otherElement instanceof B3) {
			RedefinedBModelAction.deleteB3(perspective, scene, otherRoleName, otherElement);
		}
		else if (otherElement instanceof C1) {
			RedefinedCModelAction.deleteC1(perspective, scene, otherRoleName, otherElement);
		}
		else if (otherElement instanceof C2) {
			RedefinedCModelAction.deleteC2(perspective, scene, otherRoleName, otherElement);
		}
	}







	/**
	 * This is a helper method which retrieves the corresponding container of an
	 * element to create.
	 * @param perspective
	 * @param scene -  the scene of the models
	 * @param currentOwner
	 * @param otherRole
	 * @return the container of the element to create.
	 */
	private static EObject getOwner(COREPerspective perspective, COREScene scene, EObject currentOwner, String otherRole) {
		EObject ownerOther = null;
	
		List<COREModelElementMapping> ownerMappings = COREPerspectiveUtil.INSTANCE.getMappings(currentOwner, scene);
		outerloop: for (COREModelElementMapping mapping : ownerMappings) {
			ownerOther = COREPerspectiveUtil.INSTANCE.getOtherElement(mapping, currentOwner);
			CORELanguageElementMapping mappingType = COREPerspectiveUtil.INSTANCE.getMappingType(perspective, mapping);
			for (MappingEnd mappingEnd : mappingType.getMappingEnds()) {
				if (mappingEnd.getRoleName().equals(otherRole)) {
					ownerOther = COREPerspectiveUtil.INSTANCE.getOtherElement(mapping, currentOwner);
					break outerloop;
				}
			}
		}
	
		return ownerOther;
	}
}


