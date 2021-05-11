package ca.mcgill.sel.core.perspective.language;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.classdiagram.CdmPackage;
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

public class ClassDiagramLanguage {
    
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
     * This method registers existing class diagram language with its details.
     * 
     * @author Hyacinth Ali
     * @return the class diagram {@link COREExternalLanguage}
     */
    private static COREExternalLanguage createLanguage() {

    // create a language concern
    COREConcern langConcern = COREModelUtil.createConcern("ClassDiagramLanguage");
    
    COREExternalLanguage language = CoreFactory.eINSTANCE.createCOREExternalLanguage();
    language.setName("Class Diagram Language");
    language.setNsURI("http://cs.mcgill.ca/sel/cdm/1.0");
    language.setResourceFactory("ca.mcgill.sel.classdiagram.util.CdmResourceFactoryImpl");
    language.setAdapterFactory("ca.mcgill.sel.classdiagram.provider.CdmItemProviderAdapterFactory");
    language.setWeaverClassName("ca.mcgill.sel.ram.weaver.RAMWeaver");
    language.setFileExtension("cdm");
    language.setModelUtilClassName("ca.mcgill.sel.classdiagram.util.CdmModelUtil");
    
    createLanguageElements(language);
    
    createLanguageActions(language);

    langConcern.getArtefacts().add(language);
    
    String language1FileName = "/Users/hyacinthali/git/touchram/ca.mcgill.sel.ram/resources/models/testlanguages/"
            + "ClassDiagramLanguage";

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
        createCORELanguageElement(language, CdmPackage.eINSTANCE.getClassDiagram());
    
        // create class metaclass core language element
        CORELanguageElement clazz = createCORELanguageElement(language, CdmPackage.eINSTANCE.getClass_());
        
        // create name nested elements in the metaclass, Class
        createNestedCORELanguageElement(language, CdmPackage.eINSTANCE.getNamedElement_Name(), clazz, "name");
        
        // class abstract nested elements in the metaclass, Class
        createNestedCORELanguageElement(language, CdmPackage.eINSTANCE.getClassifier_Abstract(), clazz, "abstract");
        
        // class visibility nested elements in the metaclass, Class
        createNestedCORELanguageElement(language, CdmPackage.eINSTANCE.getClassifier_Visibility(), clazz, "visibility");
        
        
        // create attribute core language element
        CORELanguageElement attribute = createCORELanguageElement(language, CdmPackage.eINSTANCE.getAttribute());
        
        
        
        // attribute type nested elements in the metaclass, Attribute
        createNestedCORELanguageElement(language, CdmPackage.eINSTANCE.getTypedElement_Type(), attribute, "type");
        
        // create nested core language element attribute, name of an attribute
        createNestedCORELanguageElement(language, CdmPackage.eINSTANCE.getNamedElement_Name(), attribute, "name");
    }
    
    /**
     * This method creates an instance of {@link CORELanguageElement} for a given language {@link COREExternalLanguage}
     * and its existing language element.
     * @param language - the language in question.
     * @param languageElement - the existing language element.
     * @return the new instance of {@link CORELanguageElement}
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
     * This method creates an instance of {@link CORELanguageElement}, nested element, for a given language {@link COREExternalLanguage}
     * and its existing language element.
     * @param language - the language in question.
     * @param languageElement - the existing language element.
     * @param container - the {@link CORELanguageElement} container of the new element
     * @param name - name of the language element feature/attribute
     */
    private static void createNestedCORELanguageElement(COREExternalLanguage language, EObject languageElement, 
    		CORELanguageElement container, String name) {
    	
    	// create core language element
        CORELanguageElement coreLanguageElement = CoreFactory.eINSTANCE.createCORELanguageElement();
        coreLanguageElement.setName(name);
        coreLanguageElement.setLanguageElement(CdmPackage.eINSTANCE.getNamedElement_Name());
        
        container.getNestedElements().add(coreLanguageElement);
        coreLanguageElement.setOwner(container);
    }
    
    /**
     * This method creates class diagram language actions, which can be manipulates by the perspectives
     * which reuse the class diagram language. 
     * 
     * @author Hyacinth Ali
     * @param language - the class diagram language
     */
    private static void createLanguageActions(COREExternalLanguage language) {

        // create language actions
        CORELanguageAction lAction1 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction1.setName("ClassDiagram.Class.add");
        language.getActions().add(lAction1);             
        CORELanguageAction lAction2 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction2.setName("ClassDiagram.Class.edit");
        language.getActions().add(lAction2);             
        CORELanguageAction lAction3 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction3.setName("ClassDiagram.Class.delete");
        language.getActions().add(lAction3);             
        CORELanguageAction lAction4 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction4.setName("ClassDiagram.Note.add");
        language.getActions().add(lAction4);             
        CORELanguageAction lAction5 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction5.setName("ClassDiagram.Note.edit");
        language.getActions().add(lAction5);             
        CORELanguageAction lAction6 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction6.setName("ClassDiagram.Note.delete");
        language.getActions().add(lAction6);             
        CORELanguageAction lAction7 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction7.setName("ClassDiagram.Association.add");
        language.getActions().add(lAction7);             
        CORELanguageAction lAction8 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction8.setName("ClassDiagram.Association.edit");
        language.getActions().add(lAction8);             
        CORELanguageAction lAction9 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction9.setName("ClassDiagram.Association.delete");
        language.getActions().add(lAction9);             
        CORELanguageAction lAction10 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction10.setName("ClassDiagram.NaryAssociation.add");
        language.getActions().add(lAction10);             
        CORELanguageAction lAction11 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction11.setName("ClassDiagram.NaryAssociation.delete");
        language.getActions().add(lAction11);             
        CORELanguageAction lAction12 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction12.setName("ClassDiagram.Classifier.Attribute.add");
        language.getActions().add(lAction12);             
        CORELanguageAction lAction13 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction13.setName("ClassDiagram.Classifier.Attribute.edit");
        language.getActions().add(lAction13);             
        CORELanguageAction lAction14 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction14.setName("ClassDiagram.Classifier.Attribute.delete");
        language.getActions().add(lAction14);             
        CORELanguageAction lAction15 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction15.setName("ClassDiagram.CDEnum.add");
        language.getActions().add(lAction15);             
        CORELanguageAction lAction16 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction16.setName("ClassDiagram.CDEnum.edit");
        language.getActions().add(lAction16);             
        CORELanguageAction lAction17 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction17.setName("ClassDiagram.CDEnum.delete");
        language.getActions().add(lAction17);             
        CORELanguageAction lAction18 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction18.setName("ClassDiagram.StructuralFeature.static.edit");
        language.getActions().add(lAction18);             
        CORELanguageAction lAction19 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction19.setName("ClassDiagram.ImplementationClass.add");
        language.getActions().add(lAction19);             
        CORELanguageAction lAction20 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction20.setName("ClassDiagram.ImplementationClass.edit");
        language.getActions().add(lAction20);             
        CORELanguageAction lAction21 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction21.setName("ClassDiagram.ImplementationClass.delete");
        language.getActions().add(lAction21);             
        CORELanguageAction lAction22 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction22.setName("ClassDiagram.Classifier.Operation.add");
        language.getActions().add(lAction22);             
        CORELanguageAction lAction23 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction23.setName("ClassDiagram.Classifier.Operation.edit");
        language.getActions().add(lAction23);             
        CORELanguageAction lAction24 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction24.setName("ClassDiagram.Classifier.Operation.delete");
        language.getActions().add(lAction24);             
        CORELanguageAction lAction25 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction25.setName("ClassDiagram.Classifier.Operation.Parameter.add");
        language.getActions().add(lAction25);             
        CORELanguageAction lAction26 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction26.setName("ClassDiagram.Classifier.Operation.Parameter.edit");
        language.getActions().add(lAction26);             
        CORELanguageAction lAction27 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction27.setName("ClassDiagram.Classifier.Operation.Parameter.delete");
        language.getActions().add(lAction27);             
        CORELanguageAction lAction28 = CoreFactory.eINSTANCE.createCORELanguageAction();
        lAction28.setName("ClassDiagram.VisibilityType.edit");
        language.getActions().add(lAction28); 
    }
}
