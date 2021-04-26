package ca.mcgill.sel.language2.util;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.core.controller.ModelUtil;
import ca.mcgill.sel.language2.Language2;
import ca.mcgill.sel.language2.Language2Factory;

/**
 * Helper class with convenient static methods for working with language2 (template unit tests) model objects.
 * @author hyacinthali
 *
 */
public class Language2ModelUtil implements ModelUtil {
	
	/**
     * Creates a new language2 model and associated entities
     * @param name The name of the language2 model
     * @return The new language2 model
     */
    public static Language2 createLanguage2Model(String name) {
    	
    	Language2 em = Language2Factory.eINSTANCE.createLanguage2();     
    	em.setName(name);
        return em;
    }

	@Override
	public EObject createNewEmptyModel(String name) {
		return createLanguage2Model(name);
	}

}
