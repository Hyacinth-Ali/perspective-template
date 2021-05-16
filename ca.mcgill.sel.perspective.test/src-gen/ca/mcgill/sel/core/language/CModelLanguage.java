package ca.mcgill.sel.core.language;

import java.io.IOException;
import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.commons.emf.util.AdapterFactoryRegistry;
import ca.mcgill.sel.commons.emf.util.ResourceManager;
import ca.mcgill.sel.core.util.CoreResourceFactoryImpl;
import ca.mcgill.sel.core.provider.CoreItemProviderAdapterFactory;
import ca.mcgill.sel.ram.ui.utils.ResourceUtils;
import ca.mcgill.sel.core.util.COREModelUtil;

import ca.mcgill.sel.core.*;

import ca.mcgill.sel.cmodel.*;

public class CModelLanguage {

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

    /**
     * This method registers existing language (with its details) in TouchCORE.
     *
     * @author Hyacinth Ali
     * @return the class diagram {@link COREExternalLanguage}
     *
     * @generated
     */
    public static COREExternalLanguage createLanguage() {

    // create a language concern
    COREConcern langConcern = COREModelUtil.createConcern("CModelLanguage");

    COREExternalLanguage language = CoreFactory.eINSTANCE.createCOREExternalLanguage();
    language.setName("CModelLanguage");
    language.setNsURI("http://cs.mcgill.ca/sel/cmodel/1.0");
    language.setResourceFactory("ca.mcgill.sel.cmodel.util.CdmResourceFactoryImpl");
    language.setAdapterFactory("ca.mcgill.sel.cmodel.provider.CdmItemProviderAdapterFactory");
    language.setWeaverClassName("");
    language.setFileExtension("cmodel");
    language.setModelUtilClassName("ca.mcgill.sel.cmodel.util.CModelUtil");

    createLanguageElements(language);

    createLanguageActions(language);

    langConcern.getArtefacts().add(language);

    String language1FileName = "/Users/hyacinthali/workspace/TouchCORE2/touchram/ca.mcgill.sel.ram/resources/models/testlanguages/"
            + "CModelLanguage";

     try {
         ResourceManager.saveModel(langConcern, language1FileName.concat("." + "core"));
     } catch (IOException e) {
         // Shouldn't happen.
         e.printStackTrace();
     }

     return language;
    }

    private static void createLanguageElements(COREExternalLanguage language) {

        // create classdiagram core language element
        CORELanguageElement cModelElement = createCORELanguageElement(language, CmodelPackage.eINSTANCE.getCModel());


        // create classdiagram core language element
        CORELanguageElement c1Element = createCORELanguageElement(language, CmodelPackage.eINSTANCE.getC1());

        // create nested element
        CORELanguageElement c1Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        c1Name.setName("name");
        c1Name.setLanguageElement(CmodelPackage.eINSTANCE.getNamedElement_Name());
        
        c1Element.getNestedElements().add(c1Name);
        c1Name.setOwner(c1Element);
        

        // create classdiagram core language element
        CORELanguageElement c2Element = createCORELanguageElement(language, CmodelPackage.eINSTANCE.getC2());

        // create nested element
        CORELanguageElement c2Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        c2Name.setName("name");
        c2Name.setLanguageElement(CmodelPackage.eINSTANCE.getNamedElement_Name());
        
        c2Element.getNestedElements().add(c2Name);
        c2Name.setOwner(c2Element);
        

        // create classdiagram core language element
        CORELanguageElement c3Element = createCORELanguageElement(language, CmodelPackage.eINSTANCE.getC3());

        // create nested element
        CORELanguageElement c3Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        c3Name.setName("name");
        c3Name.setLanguageElement(CmodelPackage.eINSTANCE.getNamedElement_Name());
        
        c3Element.getNestedElements().add(c3Name);
        c3Name.setOwner(c3Element);
        

        // create classdiagram core language element
        CORELanguageElement c4Element = createCORELanguageElement(language, CmodelPackage.eINSTANCE.getC4());

        // create nested element
        CORELanguageElement c4Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        c4Name.setName("name");
        c4Name.setLanguageElement(CmodelPackage.eINSTANCE.getNamedElement_Name());
        
        c4Element.getNestedElements().add(c4Name);
        c4Name.setOwner(c4Element);
        


    }

    /**
    * This method creates an instance of {@link CORELanguageElement} for a given language {@link COREExternalLanguage}
    * and its existing language element.
    * @param language - the language in question.
    * @param languageElement - the existing language element.
    * @return the new instance of {@link CORELanguageElement}
    *
    * @generated
    */
    private static CORELanguageElement createCORELanguageElement(COREExternalLanguage language,
            EObject languageElement) {

        // create core language element
        CORELanguageElement coreLanguageElement = CoreFactory.eINSTANCE.createCORELanguageElement();
        coreLanguageElement.setLanguageElement(languageElement);
        language.getLanguageElements().add(coreLanguageElement);

        return coreLanguageElement;
    }

    /**
    * This method creates language actions, which can be manipulated by the perspectives
    * which reuse the language.
    *
    * @author Hyacinth Ali
    * @param language - the language
    *
    * @generated
    */
    private static void createLanguageActions(COREExternalLanguage language) {

    }
}
