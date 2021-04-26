package ca.mcgill.sel.language1.util;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.core.controller.ModelUtil;
import ca.mcgill.sel.language1.Language1;
import ca.mcgill.sel.language1.Language1Factory;

/**
 * Helper class with convenient static methods for working with language1 (templates unit tests) model objects.
 * @author hyacinthali
 *
 */
public class Language1ModelUtil implements ModelUtil {
	
	/**
     * Creates a new langauge1 model and associated entities
     * @param name The name of the language1 model
     * @return The new language1 model
     */
    public static Language1 createLanguage1Model(String name) {
    	
    	Language1 language1 = Language1Factory.eINSTANCE.createLanguage1();       
    	language1.setName(name);
        return language1;
    }

	@Override
	public EObject createNewEmptyModel(String name) {
		return createLanguage1Model(name);
	}

}
