package ca.mcgill.sel.perspective.testfonduemapping;

import java.util.List;
import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.core.*;
import ca.mcgill.sel.core.perspective.COREPerspectiveUtil;

import ca.mcgill.sel.cmodel.*;
import ca.mcgill.sel.amodel.*;
import ca.mcgill.sel.bmodel.*;
import ca.mcgill.sel.amodel.controller.*;
import ca.mcgill.sel.bmodel.controller.*;
import ca.mcgill.sel.cmodel.controller.*;

public class CModelFacadeAction {







	public static EObject createOtherElementsForC1(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(BmodelPackage.eINSTANCE.getB1())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			BModel otherOwner = (BModel) o;
			newElement = RedefinedBModelAction.createNewB1(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static EObject createOtherElementsForC2(COREPerspective perspective, EObject otherLE, String otherRoleName, COREScene scene, 
			EObject owner, String name) {
		EObject newElement = null;
		if (otherLE.equals(AmodelPackage.eINSTANCE.getA2())) {
			// Handle parameter mappings
			EObject o = getOwner(perspective, scene, owner, otherRoleName);
			AModel otherOwner = (AModel) o;
			newElement = RedefinedAModelAction.createNewA2(perspective, scene, otherRoleName, 
								true, otherOwner, name);
		}
		
		return newElement;						
	}

	public static void deleteModelElement(EObject otherElement) {
		if (otherElement instanceof A2) {
			AModelController.getInstance().removeA2((A2) otherElement);
		}
		else if (otherElement instanceof A3) {
			AModelController.getInstance().removeA3((A3) otherElement);
		}
		else if (otherElement instanceof A4) {
			AModelController.getInstance().removeA4((A4) otherElement);
		}
		else if (otherElement instanceof B1) {
			BModelController.getInstance().removeB1((B1) otherElement);
		}
		else if (otherElement instanceof B3) {
			BModelController.getInstance().removeB3((B3) otherElement);
		}
		else if (otherElement instanceof C1) {
			CModelController.getInstance().removeC1((C1) otherElement);
		}
		else if (otherElement instanceof C2) {
			CModelController.getInstance().removeC2((C2) otherElement);
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

