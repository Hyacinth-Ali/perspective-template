
package ca.mcgill.sel.perspective.test;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.amodel.AmodelPackage;
import ca.mcgill.sel.bmodel.BmodelPackage;
import ca.mcgill.sel.core.COREExternalLanguage;
import ca.mcgill.sel.core.CORELanguageElement;
import ca.mcgill.sel.core.CORELanguageElementMapping;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREPerspectiveAction;
import ca.mcgill.sel.core.Cardinality;
import ca.mcgill.sel.core.CoreFactory;
import ca.mcgill.sel.core.MappingEnd;

public class MainPerspectiveTest {

    public static COREPerspective initializePerspective() {
    	
    	COREPerspective perspective = CoreFactory.eINSTANCE.createCOREPerspective();
		perspective.setName("Template Test");

		// create external languages, if any
		COREExternalLanguage language1 = AModelLanguage.createLanguage();
		perspective.getLanguages().put("A_Model", language1);

		COREExternalLanguage language2 = BModelLanguage.createLanguage();
		perspective.getLanguages().put("B_Model", language2);

        // create perspective actions
        createPerspectiveAction(perspective);

        // create perspective mappings
        createPerspectiveMappings(perspective);

        return perspective;
    }

    private static void createPerspectiveAction(COREPerspective perspective) {
        // create perspective actions

        COREPerspectiveAction pAction = null;
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewA1");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewA2");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewA3");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewA4");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewA5");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewA6");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewA7");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewA8");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewA9");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewA10");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewA11");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewA12");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteA1");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        

    }

    private static void createPerspectiveMappings(COREPerspective perspective) {

        // language element mapping 
        createLanguageElementMapping(perspective, Cardinality.COMPULSORY, "A_Model", 
        AmodelPackage.eINSTANCE.getAModel(), Cardinality.COMPULSORY, "B_Model", BmodelPackage.eINSTANCE.getBModel());
            
	 	        		 	        
        
        ElementMapping a1_B1Mapping = createLanguageElementMapping(perspective, Cardinality.COMPULSORY,
         "A_Model", AmodelPackage.eINSTANCE.getA1(), Cardinality.OPTIONAL, "B_Model",
                     BmodelPackage.eINSTANCE.getB1());
        
        CORELanguageElementMapping a1_B1MappingType = a1_B1Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a1_B1MappingFromLanguageELement = a1_B1Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a1_B1MappingToLanguageELement = a1_B1Mapping.getToLanguageElement();
        

                          createNestedMapping(a1_B1MappingType, a1_B1MappingFromLanguageELement, 
                            a1_B1MappingToLanguageELement, "name", "name", 
                            "A_Model", "B_Model", true);

                  
	 	        		 	        
        
        ElementMapping a2_B2Mapping = createLanguageElementMapping(perspective, Cardinality.COMPULSORY,
         "A_Model", AmodelPackage.eINSTANCE.getA2(), Cardinality.COMPULSORY, "B_Model",
                     BmodelPackage.eINSTANCE.getB2());
        
        CORELanguageElementMapping a2_B2MappingType = a2_B2Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a2_B2MappingFromLanguageELement = a2_B2Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a2_B2MappingToLanguageELement = a2_B2Mapping.getToLanguageElement();
        

                          createNestedMapping(a2_B2MappingType, a2_B2MappingFromLanguageELement, 
                            a2_B2MappingToLanguageELement, "name", "name", 
                            "A_Model", "B_Model", true);

                  
	 	        		 	        
        
        ElementMapping a3_B3Mapping = createLanguageElementMapping(perspective, Cardinality.COMPULSORY,
         "A_Model", AmodelPackage.eINSTANCE.getA3(), Cardinality.OPTIONAL_MULTIPLE, "B_Model",
                     BmodelPackage.eINSTANCE.getB3());
        
        CORELanguageElementMapping a3_B3MappingType = a3_B3Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a3_B3MappingFromLanguageELement = a3_B3Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a3_B3MappingToLanguageELement = a3_B3Mapping.getToLanguageElement();
        

                          createNestedMapping(a3_B3MappingType, a3_B3MappingFromLanguageELement, 
                            a3_B3MappingToLanguageELement, "name", "name", 
                            "A_Model", "B_Model", true);

                  
	 	        		 	        
        
        ElementMapping a4_B4Mapping = createLanguageElementMapping(perspective, Cardinality.COMPULSORY,
         "A_Model", AmodelPackage.eINSTANCE.getA4(), Cardinality.COMPULSORY_MULTIPLE, "B_Model",
                     BmodelPackage.eINSTANCE.getB4());
        
        CORELanguageElementMapping a4_B4MappingType = a4_B4Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a4_B4MappingFromLanguageELement = a4_B4Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a4_B4MappingToLanguageELement = a4_B4Mapping.getToLanguageElement();
        

                          createNestedMapping(a4_B4MappingType, a4_B4MappingFromLanguageELement, 
                            a4_B4MappingToLanguageELement, "name", "name", 
                            "A_Model", "B_Model", true);

                  
	 	        		 	        
        
        ElementMapping a5_B5Mapping = createLanguageElementMapping(perspective, Cardinality.OPTIONAL_MULTIPLE,
         "A_Model", AmodelPackage.eINSTANCE.getA5(), Cardinality.OPTIONAL, "B_Model",
                     BmodelPackage.eINSTANCE.getB5());
        
        CORELanguageElementMapping a5_B5MappingType = a5_B5Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a5_B5MappingFromLanguageELement = a5_B5Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a5_B5MappingToLanguageELement = a5_B5Mapping.getToLanguageElement();
        

                          createNestedMapping(a5_B5MappingType, a5_B5MappingFromLanguageELement, 
                            a5_B5MappingToLanguageELement, "name", "name", 
                            "A_Model", "B_Model", true);

                  
	 	        		 	        
        
        ElementMapping a6_B6Mapping = createLanguageElementMapping(perspective, Cardinality.OPTIONAL_MULTIPLE,
         "A_Model", AmodelPackage.eINSTANCE.getA6(), Cardinality.COMPULSORY, "B_Model",
                     BmodelPackage.eINSTANCE.getB6());
        
        CORELanguageElementMapping a6_B6MappingType = a6_B6Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a6_B6MappingFromLanguageELement = a6_B6Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a6_B6MappingToLanguageELement = a6_B6Mapping.getToLanguageElement();
        

                          createNestedMapping(a6_B6MappingType, a6_B6MappingFromLanguageELement, 
                            a6_B6MappingToLanguageELement, "name", "name", 
                            "A_Model", "B_Model", true);

                  
	 	        		 	        
        
        ElementMapping a7_B7Mapping = createLanguageElementMapping(perspective, Cardinality.OPTIONAL_MULTIPLE,
         "A_Model", AmodelPackage.eINSTANCE.getA7(), Cardinality.OPTIONAL_MULTIPLE, "B_Model",
                     BmodelPackage.eINSTANCE.getB7());
        
        CORELanguageElementMapping a7_B7MappingType = a7_B7Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a7_B7MappingFromLanguageELement = a7_B7Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a7_B7MappingToLanguageELement = a7_B7Mapping.getToLanguageElement();
        

                          createNestedMapping(a7_B7MappingType, a7_B7MappingFromLanguageELement, 
                            a7_B7MappingToLanguageELement, "name", "name", 
                            "A_Model", "B_Model", true);

                  
	 	        		 	        
        
        ElementMapping a8_B8Mapping = createLanguageElementMapping(perspective, Cardinality.OPTIONAL_MULTIPLE,
         "A_Model", AmodelPackage.eINSTANCE.getA8(), Cardinality.COMPULSORY_MULTIPLE, "B_Model",
                     BmodelPackage.eINSTANCE.getB8());
        
        CORELanguageElementMapping a8_B8MappingType = a8_B8Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a8_B8MappingFromLanguageELement = a8_B8Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a8_B8MappingToLanguageELement = a8_B8Mapping.getToLanguageElement();
        

                          createNestedMapping(a8_B8MappingType, a8_B8MappingFromLanguageELement, 
                            a8_B8MappingToLanguageELement, "name", "name", 
                            "A_Model", "B_Model", true);

                  
	 	        		 	        
        
        ElementMapping a9_B9Mapping = createLanguageElementMapping(perspective, Cardinality.OPTIONAL,
         "A_Model", AmodelPackage.eINSTANCE.getA9(), Cardinality.OPTIONAL, "B_Model",
                     BmodelPackage.eINSTANCE.getB9());
        
        CORELanguageElementMapping a9_B9MappingType = a9_B9Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a9_B9MappingFromLanguageELement = a9_B9Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a9_B9MappingToLanguageELement = a9_B9Mapping.getToLanguageElement();
        

                          createNestedMapping(a9_B9MappingType, a9_B9MappingFromLanguageELement, 
                            a9_B9MappingToLanguageELement, "name", "name", 
                            "A_Model", "B_Model", true);

                  
	 	        		 	        
        
        ElementMapping a10_B10Mapping = createLanguageElementMapping(perspective, Cardinality.OPTIONAL,
         "A_Model", AmodelPackage.eINSTANCE.getA10(), Cardinality.COMPULSORY, "B_Model",
                     BmodelPackage.eINSTANCE.getB10());
        
        CORELanguageElementMapping a10_B10MappingType = a10_B10Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a10_B10MappingFromLanguageELement = a10_B10Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a10_B10MappingToLanguageELement = a10_B10Mapping.getToLanguageElement();
        

                          createNestedMapping(a10_B10MappingType, a10_B10MappingFromLanguageELement, 
                            a10_B10MappingToLanguageELement, "name", "name", 
                            "A_Model", "B_Model", true);

                  
	 	        		 	        
        
        ElementMapping a11_B11Mapping = createLanguageElementMapping(perspective, Cardinality.OPTIONAL,
         "A_Model", AmodelPackage.eINSTANCE.getA11(), Cardinality.OPTIONAL_MULTIPLE, "B_Model",
                     BmodelPackage.eINSTANCE.getB11());
        
        CORELanguageElementMapping a11_B11MappingType = a11_B11Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a11_B11MappingFromLanguageELement = a11_B11Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a11_B11MappingToLanguageELement = a11_B11Mapping.getToLanguageElement();
        

                          createNestedMapping(a11_B11MappingType, a11_B11MappingFromLanguageELement, 
                            a11_B11MappingToLanguageELement, "name", "name", 
                            "A_Model", "B_Model", true);

                  
	 	        		 	        
        
        ElementMapping a12_B12Mapping = createLanguageElementMapping(perspective, Cardinality.OPTIONAL,
         "A_Model", AmodelPackage.eINSTANCE.getA12(), Cardinality.COMPULSORY_MULTIPLE, "B_Model",
                     BmodelPackage.eINSTANCE.getB12());
        
        CORELanguageElementMapping a12_B12MappingType = a12_B12Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a12_B12MappingFromLanguageELement = a12_B12Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a12_B12MappingToLanguageELement = a12_B12Mapping.getToLanguageElement();
        

                          createNestedMapping(a12_B12MappingType, a12_B12MappingFromLanguageELement, 
                            a12_B12MappingToLanguageELement, "name", "name", 
                            "A_Model", "B_Model", true);

                  
	 	        		 	        
        
    }

    /**
     * This method creates an instance of {@link CORELanguageElementMapping}.
     * @param perspective 
     * @param fromCardinality
     * @param fromRoleName
     * @param fromMetaclass
     * @param toCardinality
     * @param toRoleName
     * @param toMetaclass
     * @return the language element mapping.
     * 
     * @author Hyacinth Ali
     */
    private static ElementMapping createLanguageElementMapping(COREPerspective perspective,
            Cardinality fromCardinality, String fromRoleName, EObject fromMetaclass, Cardinality toCardinality, 
            String toRoleName, EObject toMetaclass) {

        CORELanguageElementMapping mappingType = CoreFactory.eINSTANCE.createCORELanguageElementMapping();
        mappingType.setIdentifier(getNextMappingId(perspective));

        // from mapping end settings
        MappingEnd fromMappingEnd = CoreFactory.eINSTANCE.createMappingEnd();
        fromMappingEnd.setCardinality(fromCardinality);
        fromMappingEnd.setRoleName(fromRoleName);
        COREExternalLanguage fromLanguage = (COREExternalLanguage) perspective.getLanguages().get(fromRoleName);
        CORELanguageElement fromLanguageElement = getLanguageElement(fromLanguage, fromMetaclass);
        fromMappingEnd.setLanguageElement(fromLanguageElement);

        // to mapping end settings
        MappingEnd toMappingEnd = CoreFactory.eINSTANCE.createMappingEnd();
        toMappingEnd.setCardinality(toCardinality);
        toMappingEnd.setRoleName(toRoleName);
        COREExternalLanguage toLanguage = (COREExternalLanguage) perspective.getLanguages().get(toRoleName);
        CORELanguageElement toLanguageElement =
                getLanguageElement(toLanguage, toMetaclass);
        toMappingEnd.setLanguageElement(toLanguageElement);

        mappingType.getMappingEnds().add(fromMappingEnd);
        mappingType.getMappingEnds().add(toMappingEnd);

        perspective.getMappings().add(mappingType);

        ElementMapping elementMapping = new ElementMapping();
        elementMapping.setMappingType(mappingType);
        elementMapping.setFromLanguageElement(fromLanguageElement);
        elementMapping.setToLanguageElement(toLanguageElement);

        return elementMapping;
    }

    /**
     * This method creates nested mapping, i.e., a language element mapping which is contained in another language 
     * element mapping.
     * 
     * @author Hyacinth Ali
     * @param mappingType - the container of the nested mapping.
     * @param fromLanguageElement - from mapped language element of the mappingType
     * @param toLanguageElement - to mapped language element of the mappingType
     * @param fromNestedElementName - from nested language element name
     * @param toNestedElementName - to nested language element name
     * @param fromRoleName - the role name of the from language in the perspective.
     * @param toRoleName - the role name of the to language in the perspective.
     * @param matchMaker - the flag which determines if the values of the respective nested mapping language elements
     * can used to find corresponding element.
     */
    private static void createNestedMapping(CORELanguageElementMapping mappingType,
            CORELanguageElement fromLanguageElement, CORELanguageElement toLanguageElement, String fromNestedElementName, 
            String toNestedElementName, String fromRoleName, String toRoleName, boolean matchMaker) {

        // from nested language element, which is contained in fromLanguageElement
        CORELanguageElement fromNestedElement = getNestedElement(fromLanguageElement, fromNestedElementName);
        
        // to nested language element, which is contained in toLanguageElement
        CORELanguageElement toNestedElement = getNestedElement(toLanguageElement, toNestedElementName);

        // create the nested mapping
        CORELanguageElementMapping nestedElementMapping = CoreFactory.eINSTANCE.createCORELanguageElementMapping();
        nestedElementMapping.setMatchMaker(matchMaker);
        
        MappingEnd fromNestedElementMappingEnd = CoreFactory.eINSTANCE.createMappingEnd();
        fromNestedElementMappingEnd.setRoleName(fromRoleName);
        fromNestedElementMappingEnd.setLanguageElement(fromNestedElement);
        
        MappingEnd toNestedElementMappingEnd = CoreFactory.eINSTANCE.createMappingEnd();
        toNestedElementMappingEnd.setRoleName(toRoleName);
        toNestedElementMappingEnd.setLanguageElement(toNestedElement);
        
        nestedElementMapping.getMappingEnds().add(fromNestedElementMappingEnd);
        fromNestedElementMappingEnd.setType(nestedElementMapping);
        nestedElementMapping.getMappingEnds().add(toNestedElementMappingEnd);
        toNestedElementMappingEnd.setType(nestedElementMapping);
         
        mappingType.getNestedMappings().add(nestedElementMapping);
    }

    /**
     * This method returns an instance of {@link CORELanguageElement} based on the language container and the
     * referenced language element.
     * 
     * @param language, the container of the language element.
     * @param element of the interest.
     * @return the language element.
     */
    private static CORELanguageElement getLanguageElement(COREExternalLanguage language, EObject element) {
        CORELanguageElement languageElement = null;
        for (CORELanguageElement le : language.getLanguageElements()) {
            if (le.getLanguageElement().equals(element)) {
                languageElement = le;
                break;
            }
        }

        return languageElement;

    }

    /**
     * This helper method returns an instance of a {@link CORELanguageElement} (most structural feature) which are 
     * contained in another language element. E.g., the structural feature of the name in a class (i.e., a language 
     * element).
     * @param owner of the language element to be retrieved.
     * @param elementName the given name for the element.
     * @return the contained element.
     */
    private static CORELanguageElement getNestedElement(CORELanguageElement owner, String elementName) {
        CORELanguageElement nestedElement = null;
        for (CORELanguageElement element : owner.getNestedElements()) {
            if (element.getName().equals(elementName)) {
                nestedElement = element;
                break;
            }
        }
        return nestedElement;
    }
    
	private static int getNextMappingId(COREPerspective perspective) {

		int idNumber = 0;
		for (CORELanguageElementMapping lem : perspective.getMappings()) {
			if (lem.getIdentifier() > idNumber) {
				idNumber = lem.getIdentifier();
			}
		}
		return idNumber + 1;
	}
}


