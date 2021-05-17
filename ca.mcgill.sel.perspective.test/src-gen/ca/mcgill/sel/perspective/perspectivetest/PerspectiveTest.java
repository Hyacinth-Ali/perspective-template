package ca.mcgill.sel.perspective.perspectivetest;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import ca.mcgill.sel.commons.ResourceUtil;
import ca.mcgill.sel.commons.emf.util.AdapterFactoryRegistry;
import ca.mcgill.sel.commons.emf.util.ResourceManager;
import ca.mcgill.sel.core.COREArtefact;
import ca.mcgill.sel.core.COREConcern;
import ca.mcgill.sel.core.COREExternalLanguage;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.CoreFactory;
import ca.mcgill.sel.core.CorePackage;
import ca.mcgill.sel.core.provider.CoreItemProviderAdapterFactory;
import ca.mcgill.sel.core.util.COREModelUtil;
import ca.mcgill.sel.core.util.CoreResourceFactoryImpl;
import ca.mcgill.sel.ram.ui.utils.ResourceUtils;

/**
 * This is the base class for creating and then saving a perspective. To instantiate and then save
 * the bnew poerspective, just run the class as a regular java class..
 * 
 * @author Hyacinth Ali
 *
 *@generated
 *
 */
public class PerspectiveTest {
    
 public static void main(String[] args) {
        
        // Initialize ResourceManager
        ResourceManager.initialize();
    
        // Initialize CORE packages.
        CorePackage.eINSTANCE.eClass();
    
        // Register resource factories
        ResourceManager.registerExtensionFactory("core", new CoreResourceFactoryImpl());
    
        // Initialize adapter factories
        AdapterFactoryRegistry.INSTANCE.addAdapterFactory(CoreItemProviderAdapterFactory.class);
        
        ResourceUtils.loadLibraries();
       
        // create a perspective
        COREConcern perspectiveConcern = COREModelUtil.createConcern("Template Test");
        
        COREPerspective perspective = CoreFactory.eINSTANCE.createCOREPerspective();
        perspective.setName("Template Test");
        
        //Add perspective to the concern
        perspectiveConcern.getArtefacts().add(perspective);
        

        // Add existing external languages, if any
        List<String> languages = ResourceUtil.getResourceListing("models/languages/", ".core");
        if (languages != null) {
        	for (String l : languages) {
        		// load existing languages
        		URI fileURI = URI.createURI(l);
        		COREConcern languageConcern = (COREConcern) ResourceManager.loadModel(fileURI);
        		for (COREArtefact a : languageConcern.getArtefacts()) {
        			if (a instanceof COREExternalLanguage) {
        				COREExternalLanguage existingLanguage = (COREExternalLanguage) a;
        				if (existingLanguage.getName().equals("AModel")) {
        					perspective.getLanguages().put("A_Model", existingLanguage);
        				} 
        			}
        		}
        	}
        	for (String l : languages) {
        		// load existing languages
        		URI fileURI = URI.createURI(l);
        		COREConcern languageConcern = (COREConcern) ResourceManager.loadModel(fileURI);
        		for (COREArtefact a : languageConcern.getArtefacts()) {
        			if (a instanceof COREExternalLanguage) {
        				COREExternalLanguage existingLanguage = (COREExternalLanguage) a;
        				if (existingLanguage.getName().equals("BModel")) {
        					perspective.getLanguages().put("B_Model", existingLanguage);
        				} 
        			}
        		}
        	}

        }
        
        // initialize perspective with perspective actions and mappings
        PerspectiveTestSpecification.initializePerspective(perspective);
        
        String fileName = "/Users/hyacinthali/workspace/TouchCORE2/touchram/ca.mcgill.sel.ram/resources/models/perspectives/"
           + "PerspectiveTest_Perspective";
        
        try {
            ResourceManager.saveModel(perspectiveConcern, fileName.concat("." + "core"));
        } catch (IOException e) {
            // Shouldn't happen.
            e.printStackTrace();
        } 
   }
}

