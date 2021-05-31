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

import ca.mcgill.sel.bmodel.*;

public class BModelLanguage {

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
    // COREConcern langConcern = COREModelUtil.createConcern("BModelLanguage");

    COREExternalLanguage language = CoreFactory.eINSTANCE.createCOREExternalLanguage();
    language.setName("BModelLanguage");
    language.setNsURI("http://cs.mcgill.ca/sel/cmodel/1.0");
    language.setResourceFactory("ca.mcgill.sel.cmodel.util.CdmResourceFactoryImpl");
    language.setAdapterFactory("ca.mcgill.sel.cmodel.provider.CdmItemProviderAdapterFactory");
    language.setWeaverClassName("");
    language.setFileExtension("bmodel");
    language.setModelUtilClassName("ca.mcgill.sel.cmodel.util.CModelUtil");

    createLanguageElements(language);

    createLanguageActions(language);

    // langConcern.getArtefacts().add(language);

    // String language1FileName = "/Users/hyacinthali/workspace/TouchCORE2/touchram/ca.mcgill.sel.ram/resources/models/languages/"
    //         + "BModelLanguage";

    // try {
    //     ResourceManager.saveModel(langConcern, language1FileName.concat("." + "core"));
    // } catch (IOException e) {
    //     // Shouldn't happen.
    //    e.printStackTrace();
    // }

     return language;
    }

    private static void createLanguageElements(COREExternalLanguage language) {

        // create classdiagram core language element
        CORELanguageElement bModelElement = createCORELanguageElement(language, BmodelPackage.eINSTANCE.getBModel());


        // create classdiagram core language element
        CORELanguageElement b1Element = createCORELanguageElement(language, BmodelPackage.eINSTANCE.getB1());

        // create nested element
        CORELanguageElement b1Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        b1Name.setName("name");
        b1Name.setLanguageElement(BmodelPackage.eINSTANCE.getNamedElement_Name());
        
        b1Element.getNestedElements().add(b1Name);
        b1Name.setOwner(b1Element);
        

        // create classdiagram core language element
        CORELanguageElement b2Element = createCORELanguageElement(language, BmodelPackage.eINSTANCE.getB2());

        // create nested element
        CORELanguageElement b2Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        b2Name.setName("name");
        b2Name.setLanguageElement(BmodelPackage.eINSTANCE.getNamedElement_Name());
        
        b2Element.getNestedElements().add(b2Name);
        b2Name.setOwner(b2Element);
        

        // create classdiagram core language element
        CORELanguageElement b3Element = createCORELanguageElement(language, BmodelPackage.eINSTANCE.getB3());

        // create nested element
        CORELanguageElement b3Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        b3Name.setName("name");
        b3Name.setLanguageElement(BmodelPackage.eINSTANCE.getNamedElement_Name());
        
        b3Element.getNestedElements().add(b3Name);
        b3Name.setOwner(b3Element);
        

        // create classdiagram core language element
        CORELanguageElement b4Element = createCORELanguageElement(language, BmodelPackage.eINSTANCE.getB4());

        // create nested element
        CORELanguageElement b4Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        b4Name.setName("name");
        b4Name.setLanguageElement(BmodelPackage.eINSTANCE.getNamedElement_Name());
        
        b4Element.getNestedElements().add(b4Name);
        b4Name.setOwner(b4Element);
        

        // create classdiagram core language element
        CORELanguageElement b5Element = createCORELanguageElement(language, BmodelPackage.eINSTANCE.getB5());

        // create nested element
        CORELanguageElement b5Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        b5Name.setName("name");
        b5Name.setLanguageElement(BmodelPackage.eINSTANCE.getNamedElement_Name());
        
        b5Element.getNestedElements().add(b5Name);
        b5Name.setOwner(b5Element);
        

        // create classdiagram core language element
        CORELanguageElement b6Element = createCORELanguageElement(language, BmodelPackage.eINSTANCE.getB6());

        // create nested element
        CORELanguageElement b6Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        b6Name.setName("name");
        b6Name.setLanguageElement(BmodelPackage.eINSTANCE.getNamedElement_Name());
        
        b6Element.getNestedElements().add(b6Name);
        b6Name.setOwner(b6Element);
        

        // create classdiagram core language element
        CORELanguageElement b7Element = createCORELanguageElement(language, BmodelPackage.eINSTANCE.getB7());

        // create nested element
        CORELanguageElement b7Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        b7Name.setName("name");
        b7Name.setLanguageElement(BmodelPackage.eINSTANCE.getNamedElement_Name());
        
        b7Element.getNestedElements().add(b7Name);
        b7Name.setOwner(b7Element);
        

        // create classdiagram core language element
        CORELanguageElement b8Element = createCORELanguageElement(language, BmodelPackage.eINSTANCE.getB8());

        // create nested element
        CORELanguageElement b8Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        b8Name.setName("name");
        b8Name.setLanguageElement(BmodelPackage.eINSTANCE.getNamedElement_Name());
        
        b8Element.getNestedElements().add(b8Name);
        b8Name.setOwner(b8Element);
        

        // create classdiagram core language element
        CORELanguageElement b9Element = createCORELanguageElement(language, BmodelPackage.eINSTANCE.getB9());

        // create nested element
        CORELanguageElement b9Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        b9Name.setName("name");
        b9Name.setLanguageElement(BmodelPackage.eINSTANCE.getNamedElement_Name());
        
        b9Element.getNestedElements().add(b9Name);
        b9Name.setOwner(b9Element);
        

        // create classdiagram core language element
        CORELanguageElement b10Element = createCORELanguageElement(language, BmodelPackage.eINSTANCE.getB10());

        // create nested element
        CORELanguageElement b10Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        b10Name.setName("name");
        b10Name.setLanguageElement(BmodelPackage.eINSTANCE.getNamedElement_Name());
        
        b10Element.getNestedElements().add(b10Name);
        b10Name.setOwner(b10Element);
        

        // create classdiagram core language element
        CORELanguageElement b11Element = createCORELanguageElement(language, BmodelPackage.eINSTANCE.getB11());

        // create nested element
        CORELanguageElement b11Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        b11Name.setName("name");
        b11Name.setLanguageElement(BmodelPackage.eINSTANCE.getNamedElement_Name());
        
        b11Element.getNestedElements().add(b11Name);
        b11Name.setOwner(b11Element);
        

        // create classdiagram core language element
        CORELanguageElement b12Element = createCORELanguageElement(language, BmodelPackage.eINSTANCE.getB12());

        // create nested element
        CORELanguageElement b12Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        b12Name.setName("name");
        b12Name.setLanguageElement(BmodelPackage.eINSTANCE.getNamedElement_Name());
        
        b12Element.getNestedElements().add(b12Name);
        b12Name.setOwner(b12Element);
        


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
