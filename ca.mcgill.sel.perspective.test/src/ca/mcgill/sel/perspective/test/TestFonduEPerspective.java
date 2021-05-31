
package ca.mcgill.sel.perspective.test;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.amodel.AmodelPackage;
import ca.mcgill.sel.bmodel.BmodelPackage;
import ca.mcgill.sel.cmodel.CModel;
import ca.mcgill.sel.cmodel.CmodelPackage;
import ca.mcgill.sel.core.COREExternalLanguage;
import ca.mcgill.sel.core.CORELanguageElement;
import ca.mcgill.sel.core.CORELanguageElementMapping;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREPerspectiveAction;
import ca.mcgill.sel.core.Cardinality;
import ca.mcgill.sel.core.CoreFactory;
import ca.mcgill.sel.core.MappingEnd;
import ca.mcgill.sel.core.language.CModelLanguage;

public class TestFonduEPerspective {

    public static COREPerspective initializePerspective() {

    	COREPerspective perspective = CoreFactory.eINSTANCE.createCOREPerspective();
		perspective.setName("Fondue Perspective Test");

		// create external languages
		COREExternalLanguage language1 = AModelLanguage.createLanguage();
		perspective.getLanguages().put("A_Model", language1);

		COREExternalLanguage language2 = BModelLanguage.createLanguage();
		perspective.getLanguages().put("B_Model", language2);
        
		COREExternalLanguage language3 = CModelLanguage.createLanguage();
		perspective.getLanguages().put("C_Model", language3);
        
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
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteA2");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteA3");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteA4");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteA5");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteA6");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteA7");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteA8");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteA9");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteA10");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteA11");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteA12");
        pAction.setForRole("A_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewB4");
        pAction.setForRole("B_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewB11");
        pAction.setForRole("B_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewB12");
        pAction.setForRole("B_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteB4");
        pAction.setForRole("B_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteB11");
        pAction.setForRole("B_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteB12");
        pAction.setForRole("B_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewC1");
        pAction.setForRole("C_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewC2");
        pAction.setForRole("C_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewC3");
        pAction.setForRole("C_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("createNewC4");
        pAction.setForRole("C_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteC1");
        pAction.setForRole("C_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteC2");
        pAction.setForRole("C_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteC3");
        pAction.setForRole("C_Model");
        perspective.getActions().add(pAction);
        
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("deleteC4");
        pAction.setForRole("C_Model");
        perspective.getActions().add(pAction);
        

    }

    private static void createPerspectiveMappings(COREPerspective perspective) {

        // language element mapping 
        createLanguageElementMapping(perspective, Cardinality.COMPULSORY, "A_Model", 
        AmodelPackage.eINSTANCE.getAModel(), Cardinality.COMPULSORY, "B_Model", BmodelPackage.eINSTANCE.getBModel());
            
	 	        		 	        
        createLanguageElementMapping(perspective, Cardinality.COMPULSORY, "A_Model", 
        AmodelPackage.eINSTANCE.getAModel(), Cardinality.COMPULSORY, "C_Model", CmodelPackage.eINSTANCE.getCModel());
            
	 	        		 	        
        createLanguageElementMapping(perspective, Cardinality.COMPULSORY, "B_Model", 
        BmodelPackage.eINSTANCE.getBModel(), Cardinality.COMPULSORY, "C_Model", CmodelPackage.eINSTANCE.getCModel());
            
	 	        		 	        
        
        ElementMapping a2_C2Mapping = createLanguageElementMapping(perspective, Cardinality.COMPULSORY,
         "A_Model", AmodelPackage.eINSTANCE.getA2(), Cardinality.COMPULSORY_MULTIPLE, "C_Model",
                     CmodelPackage.eINSTANCE.getC2());
        
        CORELanguageElementMapping a2_C2MappingType = a2_C2Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a2_C2MappingFromLanguageELement = a2_C2Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a2_C2MappingToLanguageELement = a2_C2Mapping.getToLanguageElement();
        

                          createNestedMapping(a2_C2MappingType, a2_C2MappingFromLanguageELement, 
                            a2_C2MappingToLanguageELement, "name", "name", 
                            "A_Model", "C_Model", true);

                  
	 	        		 	        
        
        ElementMapping a3_B3Mapping = createLanguageElementMapping(perspective, Cardinality.OPTIONAL,
         "A_Model", AmodelPackage.eINSTANCE.getA3(), Cardinality.COMPULSORY_MULTIPLE, "B_Model",
                     BmodelPackage.eINSTANCE.getB3());
        
        CORELanguageElementMapping a3_B3MappingType = a3_B3Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a3_B3MappingFromLanguageELement = a3_B3Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a3_B3MappingToLanguageELement = a3_B3Mapping.getToLanguageElement();
        

                          createNestedMapping(a3_B3MappingType, a3_B3MappingFromLanguageELement, 
                            a3_B3MappingToLanguageELement, "name", "name", 
                            "A_Model", "B_Model", true);

                  
	 	        		 	        
        
        ElementMapping a4_B1Mapping = createLanguageElementMapping(perspective, Cardinality.COMPULSORY,
         "A_Model", AmodelPackage.eINSTANCE.getA4(), Cardinality.COMPULSORY, "B_Model",
                     BmodelPackage.eINSTANCE.getB1());
        
        CORELanguageElementMapping a4_B1MappingType = a4_B1Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement a4_B1MappingFromLanguageELement = a4_B1Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement a4_B1MappingToLanguageELement = a4_B1Mapping.getToLanguageElement();
        

                          createNestedMapping(a4_B1MappingType, a4_B1MappingFromLanguageELement, 
                            a4_B1MappingToLanguageELement, "name", "name", 
                            "A_Model", "B_Model", true);

                  
	 	        		 	        
        
        ElementMapping b1_C1Mapping = createLanguageElementMapping(perspective, Cardinality.OPTIONAL,
         "B_Model", BmodelPackage.eINSTANCE.getB1(), Cardinality.COMPULSORY_MULTIPLE, "C_Model",
                     CmodelPackage.eINSTANCE.getC1());
        
        CORELanguageElementMapping b1_C1MappingType = b1_C1Mapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement b1_C1MappingFromLanguageELement = b1_C1Mapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement b1_C1MappingToLanguageELement = b1_C1Mapping.getToLanguageElement();
        

                          createNestedMapping(b1_C1MappingType, b1_C1MappingFromLanguageELement, 
                            b1_C1MappingToLanguageELement, "name", "name", 
                            "B_Model", "C_Model", true);

                  
	 	        		 	        
        
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


