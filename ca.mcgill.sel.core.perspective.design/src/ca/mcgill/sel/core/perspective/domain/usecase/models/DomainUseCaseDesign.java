package ca.mcgill.sel.core.perspective.domain.usecase.models;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import ca.mcgill.sel.commons.ResourceUtil;
import ca.mcgill.sel.commons.emf.util.AdapterFactoryRegistry;
import ca.mcgill.sel.commons.emf.util.ResourceManager;
import ca.mcgill.sel.core.COREArtefact;
import ca.mcgill.sel.core.COREConcern;
import ca.mcgill.sel.core.COREExternalLanguage;
import ca.mcgill.sel.core.CORELanguageElementMapping;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.CoreFactory;
import ca.mcgill.sel.core.CorePackage;
import ca.mcgill.sel.core.provider.CoreItemProviderAdapterFactory;
import ca.mcgill.sel.core.util.COREModelUtil;
import ca.mcgill.sel.core.util.CoreResourceFactoryImpl;
import ca.mcgill.sel.ram.ui.utils.ResourceUtils;

/**
 * This class is used to create a perspective which combines class diagram language and use case language
 * for the purposes of domain modeling, design modeling, and use case modeling.
 * 
 * @author Hyacinth Ali
 *
 */
public class DomainUseCaseDesign {
    
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
        COREConcern perspectiveConcern = COREModelUtil.createConcern("Domain UseCase");
        
        COREPerspective perspective = CoreFactory.eINSTANCE.createCOREPerspective();
        perspective.setName("Domain UseCase");
        
        //Add perspective to the concern
        perspectiveConcern.getArtefacts().add(perspective);
        
       
        // Add existing external languages, if any
        List<String> languages = ResourceUtil.getResourceListing("models/testlanguages/", ".core");
        if (languages != null) {
            for (String l : languages) {
        
                // load existing languages
                URI fileURI = URI.createURI(l);
                COREConcern languageConcern = (COREConcern) ResourceManager.loadModel(fileURI);
                for (COREArtefact a : languageConcern.getArtefacts()) {
                    if (a instanceof COREExternalLanguage) {
                        COREExternalLanguage existingLanguage = (COREExternalLanguage) a;
                        if (existingLanguage.getName().equals("ClassDiagram")) {
                            perspective.getLanguages().put("Domain_Model", existingLanguage);
                        } else if (existingLanguage.getName().equals("UseCases")) {
                            perspective.getLanguages().put("Use_Case", existingLanguage);
                        }
                    }
                }
            }
        }
        
        // initialize perspective with perspective actions and mappings
        DomainUseCasePerspective.initializePerspective(perspective);
       
        String fileName = "/Users/hyacinth/git/touchram/ca.mcgill.sel.ram/resources/models/testperspectives/"
           + "DomainUseCasePerspective";
        
        try {
            ResourceManager.saveModel(perspectiveConcern, fileName.concat("." + "core"));
        } catch (IOException e) {
            // Shouldn't happen.
            e.printStackTrace();
        } 
   }
    
    public static int getNextMappingId(COREPerspective perspective) {
        
        int idNumber = 0;
        for (CORELanguageElementMapping lem : perspective.getMappings()) {
            if (lem.getIdentifier() > idNumber) {
                idNumber = lem.getIdentifier();
            }
        }
        return idNumber + 1;
      }

}
