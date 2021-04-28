package ca.mcgill.sel.amodel.util;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.amodel.AModel;
import ca.mcgill.sel.amodel.AmodelFactory;
import ca.mcgill.sel.core.controller.ModelUtil;

/**
 * Helper class with convenient static methods for working with language2 (template unit tests) model objects.
 * @author hyacinthali
 *
 */
public class AModelUtil implements ModelUtil {
	

    public static AModel createAModel(String name) {
    	
    	AModel am = AmodelFactory.eINSTANCE.createAModel();    
    	am.setName(name);
        return am;
    }

	@Override
	public EObject createNewEmptyModel(String name) {
		return createAModel(name);
	}

}
