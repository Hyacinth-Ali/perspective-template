package ca.mcgill.sel.perspective.test;

import java.io.IOException;
import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.amodel.*;
import ca.mcgill.sel.commons.emf.util.AdapterFactoryRegistry;
import ca.mcgill.sel.commons.emf.util.ResourceManager;
import ca.mcgill.sel.core.util.CoreResourceFactoryImpl;
import ca.mcgill.sel.core.provider.CoreItemProviderAdapterFactory;
import ca.mcgill.sel.ram.ui.utils.ResourceUtils;
import ca.mcgill.sel.core.util.COREModelUtil;

import ca.mcgill.sel.core.*;

public class AModelLanguage {

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
//    COREConcern langConcern = COREModelUtil.createConcern("AModel");

    COREExternalLanguage language = CoreFactory.eINSTANCE.createCOREExternalLanguage();
    language.setName("AModel");
    language.setNsURI("http://cs.mcgill.ca/sel/amodel/1.0");
    language.setResourceFactory("ca.mcgill.sel.amodel.util.AmodelResourceFactoryImpl");
    language.setAdapterFactory("ca.mcgill.sel.amodel.provider.AmodelItemProviderAdapterFactory");
    language.setWeaverClassName("");
    language.setFileExtension("amodel");
    language.setModelUtilClassName("ca.mcgill.sel.amodel.util.AModelUtil");

    createLanguageElements(language);

    createLanguageActions(language);

//    langConcern.getArtefacts().add(language);
//
//    String language1FileName = "/Users/hyacinthali/workspace/TouchCORE2/touchram/ca.mcgill.sel.ram/resources/models/testlanguages/"
//            + "AModel";
//
//     try {
//         ResourceManager.saveModel(langConcern, language1FileName.concat("." + "core"));
//     } catch (IOException e) {
//         // Shouldn't happen.
//         e.printStackTrace();
//     }

     return language;
    }

    private static void createLanguageElements(COREExternalLanguage language) {

        // create classdiagram core language element
        CORELanguageElement aModelElement = createCORELanguageElement(language, AmodelPackage.eINSTANCE.getAModel());


        // create classdiagram core language element
        CORELanguageElement a1Element = createCORELanguageElement(language, AmodelPackage.eINSTANCE.getA1());

        // create nested element
        CORELanguageElement a1Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        a1Name.setName("name");
        a1Name.setLanguageElement(AmodelPackage.eINSTANCE.getNamedElement_Name());
        
        a1Element.getNestedElements().add(a1Name);
        a1Name.setOwner(a1Element);
        

        // create classdiagram core language element
        CORELanguageElement a2Element = createCORELanguageElement(language, AmodelPackage.eINSTANCE.getA2());

        // create nested element
        CORELanguageElement a2Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        a2Name.setName("name");
        a2Name.setLanguageElement(AmodelPackage.eINSTANCE.getNamedElement_Name());
        
        a2Element.getNestedElements().add(a2Name);
        a2Name.setOwner(a2Element);
        

        // create classdiagram core language element
        CORELanguageElement a3Element = createCORELanguageElement(language, AmodelPackage.eINSTANCE.getA3());

        // create nested element
        CORELanguageElement a3Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        a3Name.setName("name");
        a3Name.setLanguageElement(AmodelPackage.eINSTANCE.getNamedElement_Name());
        
        a3Element.getNestedElements().add(a3Name);
        a3Name.setOwner(a3Element);
        

        // create classdiagram core language element
        CORELanguageElement a4Element = createCORELanguageElement(language, AmodelPackage.eINSTANCE.getA4());

        // create nested element
        CORELanguageElement a4Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        a4Name.setName("name");
        a4Name.setLanguageElement(AmodelPackage.eINSTANCE.getNamedElement_Name());
        
        a4Element.getNestedElements().add(a4Name);
        a4Name.setOwner(a4Element);
        

        // create classdiagram core language element
        CORELanguageElement a5Element = createCORELanguageElement(language, AmodelPackage.eINSTANCE.getA5());

        // create nested element
        CORELanguageElement a5Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        a5Name.setName("name");
        a5Name.setLanguageElement(AmodelPackage.eINSTANCE.getNamedElement_Name());
        
        a5Element.getNestedElements().add(a5Name);
        a5Name.setOwner(a5Element);
        

        // create classdiagram core language element
        CORELanguageElement a6Element = createCORELanguageElement(language, AmodelPackage.eINSTANCE.getA6());

        // create nested element
        CORELanguageElement a6Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        a6Name.setName("name");
        a6Name.setLanguageElement(AmodelPackage.eINSTANCE.getNamedElement_Name());
        
        a6Element.getNestedElements().add(a6Name);
        a6Name.setOwner(a6Element);
        

        // create classdiagram core language element
        CORELanguageElement a7Element = createCORELanguageElement(language, AmodelPackage.eINSTANCE.getA7());

        // create nested element
        CORELanguageElement a7Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        a7Name.setName("name");
        a7Name.setLanguageElement(AmodelPackage.eINSTANCE.getNamedElement_Name());
        
        a7Element.getNestedElements().add(a7Name);
        a7Name.setOwner(a7Element);
        

        // create classdiagram core language element
        CORELanguageElement a8Element = createCORELanguageElement(language, AmodelPackage.eINSTANCE.getA8());

        // create nested element
        CORELanguageElement a8Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        a8Name.setName("name");
        a8Name.setLanguageElement(AmodelPackage.eINSTANCE.getNamedElement_Name());
        
        a8Element.getNestedElements().add(a8Name);
        a8Name.setOwner(a8Element);
        

        // create classdiagram core language element
        CORELanguageElement a9Element = createCORELanguageElement(language, AmodelPackage.eINSTANCE.getA9());

        // create nested element
        CORELanguageElement a9Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        a9Name.setName("name");
        a9Name.setLanguageElement(AmodelPackage.eINSTANCE.getNamedElement_Name());
        
        a9Element.getNestedElements().add(a9Name);
        a9Name.setOwner(a9Element);
        

        // create classdiagram core language element
        CORELanguageElement a10Element = createCORELanguageElement(language, AmodelPackage.eINSTANCE.getA10());

        // create nested element
        CORELanguageElement a10Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        a10Name.setName("name");
        a10Name.setLanguageElement(AmodelPackage.eINSTANCE.getNamedElement_Name());
        
        a10Element.getNestedElements().add(a10Name);
        a10Name.setOwner(a10Element);
        

        // create classdiagram core language element
        CORELanguageElement a11Element = createCORELanguageElement(language, AmodelPackage.eINSTANCE.getA11());

        // create nested element
        CORELanguageElement a11Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        a11Name.setName("name");
        a11Name.setLanguageElement(AmodelPackage.eINSTANCE.getNamedElement_Name());
        
        a11Element.getNestedElements().add(a11Name);
        a11Name.setOwner(a11Element);
        

        // create classdiagram core language element
        CORELanguageElement a12Element = createCORELanguageElement(language, AmodelPackage.eINSTANCE.getA12());

        // create nested element
        CORELanguageElement a12Name = CoreFactory.eINSTANCE.createCORELanguageElement();
        a12Name.setName("name");
        a12Name.setLanguageElement(AmodelPackage.eINSTANCE.getNamedElement_Name());
        
        a12Element.getNestedElements().add(a12Name);
        a12Name.setOwner(a12Element);
        


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
