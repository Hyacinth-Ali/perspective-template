package ca.mcgill.sel.bmodel.util;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.bmodel.BModel;
import ca.mcgill.sel.bmodel.BmodelFactory;
import ca.mcgill.sel.core.controller.ModelUtil;

/**
 * Helper class with convenient static methods for working with language2 (template unit tests) model objects.
 * @author hyacinthali
 *
 */
public class BModelUtil implements ModelUtil {
	

    public static BModel createBModel(String name) {
    	
    	BModel bm = BmodelFactory.eINSTANCE.createBModel();    
    	bm.setName(name);
        return bm;
    }

	@Override
	public EObject createNewEmptyModel(String name) {
		return createBModel(name);
	}

}
