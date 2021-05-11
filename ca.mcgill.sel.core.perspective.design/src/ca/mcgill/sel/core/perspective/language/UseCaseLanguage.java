package ca.mcgill.sel.core.perspective.language;

import java.io.IOException;

import ca.mcgill.sel.commons.emf.util.AdapterFactoryRegistry;
import ca.mcgill.sel.commons.emf.util.ResourceManager;
import ca.mcgill.sel.core.COREConcern;
import ca.mcgill.sel.core.COREExternalLanguage;
import ca.mcgill.sel.core.CORELanguageAction;
import ca.mcgill.sel.core.CORELanguageElement;
import ca.mcgill.sel.core.CoreFactory;
import ca.mcgill.sel.core.CorePackage;
import ca.mcgill.sel.core.provider.CoreItemProviderAdapterFactory;
import ca.mcgill.sel.core.util.COREModelUtil;
import ca.mcgill.sel.core.util.CoreResourceFactoryImpl;
import ca.mcgill.sel.ram.ui.utils.ResourceUtils;
import ca.mcgill.sel.usecases.UcPackage;

public class UseCaseLanguage {
    
    public static void main (String[] args) {
        
        // Initialize ResourceManager
        ResourceManager.initialize();
    
        // Initialize CORE packages.
        CorePackage.eINSTANCE.eClass();
    
        // Register resource factories
        ResourceManager.registerExtensionFactory("core", new CoreResourceFactoryImpl());
    
        // Initialize adapter factories
        AdapterFactoryRegistry.INSTANCE.addAdapterFactory(CoreItemProviderAdapterFactory.class);
        
        ResourceUtils.loadLibraries();
        
        createLanguage();
    }
    
    private static COREExternalLanguage createLanguage() {

        // create a language concern
        COREConcern langConcern = COREModelUtil.createConcern("UseCaseLanguage");
        
        COREExternalLanguage language = CoreFactory.eINSTANCE.createCOREExternalLanguage();
        language.setName("Use Cases");
        language.setNsURI("http://cs.mcgill.ca/sel/uc/1.0");
        language.setResourceFactory("ca.mcgill.sel.usecases.util.UcResourceFactoryImpl");
        language.setAdapterFactory("ca.mcgill.sel.usecases.provider.UcItemProviderAdapterFactory");
        language.setWeaverClassName("");
        language.setFileExtension("uc");
        language.setModelUtilClassName("ca.mcgill.sel.usecases.util.UcModelUtil");
        
        //language.getLanguageElements().add(LanguageElement.getActorElement());
            
        // actor
        CORELanguageAction lAction1 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction1.setName("UseCaseDiagram.Actor.add");
        language.getActions().add(lAction1);             
        CORELanguageAction lAction2 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction2.setName("UseCaseDiagram.Actor.edit");
        language.getActions().add(lAction2);             
        CORELanguageAction lAction3 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction3.setName("UseCaseDiagram.Actor.delete");
        language.getActions().add(lAction3);   
        
        // note
        CORELanguageAction lAction4 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction4.setName("UseCaseDiagram.Note.add");
        language.getActions().add(lAction4);             
        CORELanguageAction lAction5 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction5.setName("UseCaseDiagram.Note.edit");
        language.getActions().add(lAction5);             
        CORELanguageAction lAction6 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction6.setName("UseCaseDiagram.Note.delete");
        language.getActions().add(lAction6); 
        
        // set primary actor, a link
        CORELanguageAction lAction7 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction7.setName("UseCaseDiagram.PrimaryLink.add");
        language.getActions().add(lAction7);             
        CORELanguageAction lAction8 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction8.setName("UseCaseDiagram.PrimaryLink.edit");
        language.getActions().add(lAction8);             
        CORELanguageAction lAction9 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction9.setName("UseCaseDiagram.PrimaryLink.delete");
        language.getActions().add(lAction9);   
        
        // set primary actor, a link
        CORELanguageAction lAction10 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction10.setName("UseCaseDiagram.SecondaryLink.add");
        language.getActions().add(lAction10);             
        CORELanguageAction lAction11 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction11.setName("UseCaseDiagram.SecondaryLink.edit");
        language.getActions().add(lAction11);             
        CORELanguageAction lAction12 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction12.setName("UseCaseDiagram.SecondaryLink.delete");
        language.getActions().add(lAction12);   
        
        // use case
        CORELanguageAction lAction13 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction13.setName("UseCaseDiagram.UseCase.add");
        language.getActions().add(lAction13);             
        CORELanguageAction lAction14 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction14.setName("UseCaseDiagram.UseCase.edit");
        language.getActions().add(lAction14);
        CORELanguageAction lAction15 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction15.setName("UseCaseDiagram.UseCase.delete");
        language.getActions().add(lAction15);
        
        // create language elements
        CORELanguageElement useCaseDiagram = CoreFactory.eINSTANCE.createCORELanguageElement();
        useCaseDiagram.setLanguageElement(UcPackage.eINSTANCE.getUseCaseModel());
        language.getLanguageElements().add(useCaseDiagram);  
        
        CORELanguageElement actor = CoreFactory.eINSTANCE.createCORELanguageElement();
        actor.setLanguageElement(UcPackage.eINSTANCE.getActor());
        language.getLanguageElements().add(actor); 
        
        //create name language element attribute
        CORELanguageElement nameAttribute = CoreFactory.eINSTANCE.createCORELanguageElement();
        nameAttribute.setName("name");
        nameAttribute.setLanguageElement(UcPackage.eINSTANCE.getNamedElement_Name());
        
        // add name attribute
        actor.getNestedElements().add(nameAttribute);
        nameAttribute.setOwner(actor);
        
        langConcern.getArtefacts().add(language);
        
        String language1FileName = "/Users/hyacinthali/git/touchram/ca.mcgill.sel.ram/resources/models/languages/"
                + "UseCaseLanguage";

         try {
             ResourceManager.saveModel(langConcern, language1FileName.concat("." + "core"));
         } catch (IOException e) {
             // Shouldn't happen.
             e.printStackTrace();
         } 
         
         return language;
        }

}
