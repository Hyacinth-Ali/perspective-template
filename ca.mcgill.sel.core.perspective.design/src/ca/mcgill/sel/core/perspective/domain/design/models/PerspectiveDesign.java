       package ca.mcgill.sel.core.perspective.domain.design.models;

       import java.io.IOException;

import ca.mcgill.sel.commons.emf.util.AdapterFactoryRegistry;
import ca.mcgill.sel.commons.emf.util.ResourceManager;
import ca.mcgill.sel.core.COREConcern;
import ca.mcgill.sel.core.COREExternalLanguage;
import ca.mcgill.sel.core.CORELanguageElementMapping;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.CorePackage;
import ca.mcgill.sel.core.perspective.language.ClassDiagramLanguage;
import ca.mcgill.sel.core.provider.CoreItemProviderAdapterFactory;
import ca.mcgill.sel.core.util.CoreResourceFactoryImpl;
import ca.mcgill.sel.ram.ui.utils.ResourceUtils;

       public class PerspectiveDesign {
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
              
               // create a perspective and its features, if any
               COREPerspective perspective = DomainModelDesignModelPerspective.createPerspective();

//               // create external languages, if any
//               COREExternalLanguage language1 = ClassDiagramLanguage.createLanguage();
//               perspective.getLanguages().put("Domain_Model", language1);
//               perspective.getLanguages().put("Design_Model", language1);
               
//               // Add existing external languages, if any
//               List<String> languages = ResourceUtil.getResourceListing("models/languages/", ".core");
//               if (languages != null) {
//                   for (String l : languages) {
//               
//                       // load existing languages
//                       URI fileURI = URI.createURI(l);
//                       COREConcern languageConcern = (COREConcern) ResourceManager.loadModel(fileURI);
//                       for (COREArtefact a : languageConcern.getArtefacts()) {
//                           if (a instanceof COREExternalLanguage && "Existing_ClassDiagram1".equals(a.getName()) ) {
//                               COREExternalLanguage existingLanguage = (COREExternalLanguage) a;
//                               perspective.getLanguages().put("RoleNam1", existingLanguage);
//                           }
//                       }
//                   }
//               }
//               if (languages != null) {
//                   for (String l : languages) {
//               
//                       // load existing languages
//                       URI fileURI = URI.createURI(l);
//                       COREConcern languageConcern = (COREConcern) ResourceManager.loadModel(fileURI);
//                       for (COREArtefact a : languageConcern.getArtefacts()) {
//                           if (a instanceof COREExternalLanguage && "Existing_ClassDiagram2".equals(a.getName()) ) {
//                               COREExternalLanguage existingLanguage = (COREExternalLanguage) a;
//                               perspective.getLanguages().put("RoleName2", existingLanguage);
//                           }
//                       }
//                   }
//               }
               
               COREConcern perspectiveConcern = perspective.getCoreConcern();
               
               String fileName = "/Users/hyacinthali/TouchCORE/touchram/ca.mcgill.sel.ram/resources/models/testperspectives/"
                  + perspective.getName();
               
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
