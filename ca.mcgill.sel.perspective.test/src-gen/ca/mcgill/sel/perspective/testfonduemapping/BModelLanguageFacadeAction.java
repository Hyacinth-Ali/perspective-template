package ca.mcgill.sel.perspective.testfonduemapping;

import java.util.List;
import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.core.*;
import ca.mcgill.sel.core.perspective.COREPerspectiveUtil;

import ca.mcgill.sel.bmodel.*;
import ca.mcgill.sel.amodel.*;
import ca.mcgill.sel.cmodel.*;
import ca.mcgill.sel.amodel.controller.*;
import ca.mcgill.sel.bmodel.controller.*;
import ca.mcgill.sel.cmodel.controller.*;

public class BModelLanguageFacadeAction {
	public static EObject createOtherElementsForB1(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(CmodelPackage.eINSTANCE.getC1())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			CModel otherOwner = (CModel) o;
			newElement = RedefinedCModelLanguageAction.createNewC1(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}
	public static EObject createOtherElementsForB3(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(AmodelPackage.eINSTANCE.getA3())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			AModel otherOwner = (AModel) o;
			newElement = RedefinedAModelLanguageAction.createNewA3(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static void deleteModelElement(COREPerspective perspective, COREScene scene, String otherRoleName, EObject otherElement) {
		if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA2())) {
			RedefinedAModelLanguageAction.deleteA2(perspective, scene, otherRoleName, otherElement);
		}
		else if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA3())) {
			RedefinedAModelLanguageAction.deleteA3(perspective, scene, otherRoleName, otherElement);
		}
		else if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA4())) {
			RedefinedAModelLanguageAction.deleteA4(perspective, scene, otherRoleName, otherElement);
		}
		else if (otherElement.eClass().equals(BmodelPackage.eINSTANCE.getB1())) {
			RedefinedBModelLanguageAction.deleteB1(perspective, scene, otherRoleName, otherElement);
		}
		else if (otherElement.eClass().equals(BmodelPackage.eINSTANCE.getB3())) {
			RedefinedBModelLanguageAction.deleteB3(perspective, scene, otherRoleName, otherElement);
		}
		else if (otherElement.eClass().equals(CmodelPackage.eINSTANCE.getC1())) {
			RedefinedCModelLanguageAction.deleteC1(perspective, scene, otherRoleName, otherElement);
		}
		else if (otherElement.eClass().equals(CmodelPackage.eINSTANCE.getC2())) {
			RedefinedCModelLanguageAction.deleteC2(perspective, scene, otherRoleName, otherElement);
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


