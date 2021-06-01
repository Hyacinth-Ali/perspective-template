package ca.mcgill.sel.perspective.perspectivetest;

import java.util.List;
import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.core.*;
import ca.mcgill.sel.core.perspective.COREPerspectiveUtil;

import ca.mcgill.sel.amodel.*;
import ca.mcgill.sel.bmodel.*;
import ca.mcgill.sel.amodel.controller.*;
import ca.mcgill.sel.bmodel.controller.*;

public class AModelLanguageFacadeAction {
	public static EObject createOtherElementsForA1(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(BmodelPackage.eINSTANCE.getB1())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			BModel otherOwner = (BModel) o;
			newElement = RedefinedBModelLanguageAction.createNewB1(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForA2(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(BmodelPackage.eINSTANCE.getB2())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			BModel otherOwner = (BModel) o;
			newElement = RedefinedBModelLanguageAction.createNewB2(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForA4(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(BmodelPackage.eINSTANCE.getB4())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			BModel otherOwner = (BModel) o;
			newElement = RedefinedBModelLanguageAction.createNewB4(perspective, scene, otherRoleName, 
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
			newElement = RedefinedBModelLanguageAction.createNewB3(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForA5(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(BmodelPackage.eINSTANCE.getB5())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			BModel otherOwner = (BModel) o;
			newElement = RedefinedBModelLanguageAction.createNewB5(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForA6(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(BmodelPackage.eINSTANCE.getB6())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			BModel otherOwner = (BModel) o;
			newElement = RedefinedBModelLanguageAction.createNewB6(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForA7(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(BmodelPackage.eINSTANCE.getB7())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			BModel otherOwner = (BModel) o;
			newElement = RedefinedBModelLanguageAction.createNewB7(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForA8(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(BmodelPackage.eINSTANCE.getB8())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			BModel otherOwner = (BModel) o;
			newElement = RedefinedBModelLanguageAction.createNewB8(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForA9(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(BmodelPackage.eINSTANCE.getB9())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			BModel otherOwner = (BModel) o;
			newElement = RedefinedBModelLanguageAction.createNewB9(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForA10(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(BmodelPackage.eINSTANCE.getB10())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			BModel otherOwner = (BModel) o;
			newElement = RedefinedBModelLanguageAction.createNewB10(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForA11(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(BmodelPackage.eINSTANCE.getB11())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			BModel otherOwner = (BModel) o;
			newElement = RedefinedBModelLanguageAction.createNewB11(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForA12(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(BmodelPackage.eINSTANCE.getB12())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			BModel otherOwner = (BModel) o;
			newElement = RedefinedBModelLanguageAction.createNewB12(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static void deleteModelElement(COREPerspective perspective, COREScene scene, String otherRoleName, EObject otherElement) {
		if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA1())) {
			AModelController.getInstance().removeA1((A1) otherElement);
		}
		else if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA2())) {
			AModelController.getInstance().removeA2((A2) otherElement);
		}
		else if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA3())) {
			AModelController.getInstance().removeA3((A3) otherElement);
		}
		else if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA4())) {
			AModelController.getInstance().removeA4((A4) otherElement);
		}
		else if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA5())) {
			AModelController.getInstance().removeA5((A5) otherElement);
		}
		else if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA6())) {
			AModelController.getInstance().removeA6((A6) otherElement);
		}
		else if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA7())) {
			AModelController.getInstance().removeA7((A7) otherElement);
		}
		else if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA8())) {
			AModelController.getInstance().removeA8((A8) otherElement);
		}
		else if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA9())) {
			AModelController.getInstance().removeA9((A9) otherElement);
		}
		else if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA10())) {
			AModelController.getInstance().removeA10((A10) otherElement);
		}
		else if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA11())) {
			AModelController.getInstance().removeA11((A11) otherElement);
		}
		else if (otherElement.eClass().equals(AmodelPackage.eINSTANCE.getA12())) {
			AModelController.getInstance().removeA12((A12) otherElement);
		}
		else if (otherElement.eClass().equals(BmodelPackage.eINSTANCE.getB1())) {
			BModelController.getInstance().removeB1((B1) otherElement);
		}
		else if (otherElement.eClass().equals(BmodelPackage.eINSTANCE.getB2())) {
			BModelController.getInstance().removeB2((B2) otherElement);
		}
		else if (otherElement.eClass().equals(BmodelPackage.eINSTANCE.getB3())) {
			BModelController.getInstance().removeB3((B3) otherElement);
		}
		else if (otherElement.eClass().equals(BmodelPackage.eINSTANCE.getB4())) {
			BModelController.getInstance().removeB4((B4) otherElement);
		}
		else if (otherElement.eClass().equals(BmodelPackage.eINSTANCE.getB5())) {
			BModelController.getInstance().removeB5((B5) otherElement);
		}
		else if (otherElement.eClass().equals(BmodelPackage.eINSTANCE.getB6())) {
			BModelController.getInstance().removeB6((B6) otherElement);
		}
		else if (otherElement.eClass().equals(BmodelPackage.eINSTANCE.getB7())) {
			BModelController.getInstance().removeB7((B7) otherElement);
		}
		else if (otherElement.eClass().equals(BmodelPackage.eINSTANCE.getB8())) {
			BModelController.getInstance().removeB8((B8) otherElement);
		}
		else if (otherElement.eClass().equals(BmodelPackage.eINSTANCE.getB9())) {
			BModelController.getInstance().removeB9((B9) otherElement);
		}
		else if (otherElement.eClass().equals(BmodelPackage.eINSTANCE.getB10())) {
			BModelController.getInstance().removeB10((B10) otherElement);
		}
		else if (otherElement.eClass().equals(BmodelPackage.eINSTANCE.getB11())) {
			BModelController.getInstance().removeB11((B11) otherElement);
		}
		else if (otherElement.eClass().equals(BmodelPackage.eINSTANCE.getB12())) {
			BModelController.getInstance().removeB12((B12) otherElement);
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


