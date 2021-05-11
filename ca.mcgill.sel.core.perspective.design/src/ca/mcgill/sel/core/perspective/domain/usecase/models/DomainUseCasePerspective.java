package ca.mcgill.sel.core.perspective.domain.usecase.models;

import org.eclipse.emf.ecore.EObject;

import ca.mcgill.sel.classdiagram.CdmPackage;
import ca.mcgill.sel.core.COREExternalLanguage;
import ca.mcgill.sel.core.CORELanguageElement;
import ca.mcgill.sel.core.CORELanguageElementMapping;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREPerspectiveAction;
import ca.mcgill.sel.core.Cardinality;
import ca.mcgill.sel.core.CoreFactory;
import ca.mcgill.sel.core.MappingEnd;
import ca.mcgill.sel.core.perspective.design.ElementMapping;
import ca.mcgill.sel.core.perspective.domain.design.models.PerspectiveDesign;
import ca.mcgill.sel.usecases.UcPackage;

public class DomainUseCasePerspective {

    public static COREPerspective initializePerspective(COREPerspective perspective) {

        // create perspective actions
        createPerspectiveAction(perspective);

        // create perspective mappings
        createPerspectiveMappings(perspective);

        return perspective;
    }

    private static void createPerspectiveAction(COREPerspective perspective) {
        // create perspective actions

        COREPerspectiveAction pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("ClassDiagram.Class.add");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("ClassDiagram.Class.edit");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("ClassDiagram.Class.delete");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Note.add");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Note.edit");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Note.delete");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Association.add");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Association.edit");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Association.delete");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.NaryAssociation.add");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.NaryAssociation.delete");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("ClassDiagram.Classifier.Attribute.add");
        pAction.setForRole("Domain_Model");
        // testing perspective action identifier
        pAction.setActionIdentifier(1);
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("ClassDiagram.Classifier.Attribute.edit");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("ClassDiagram.Classifier.Attribute.delete");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.CDEnum.add");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.CDEnum.edit");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.CDEnum.delete");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.StructuralFeature.static.edit");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.VisibilityType.edit");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("UseCaseDiagram.Actor.add");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("UseCaseDiagram.Actor.edit");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("UseCaseDiagram.Actor.delete");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("UseCaseDiagram.Note.add");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("UseCaseDiagram.Note.edit");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("UseCaseDiagram.Note.delete");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("UseCaseDiagram.PrimaryLink.add");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("UseCaseDiagram.PrimaryLink.edit");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("UseCaseDiagram.PrimaryLink.delete");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("UseCaseDiagram.SecondaryLink.add");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("UseCaseDiagram.SecondaryLink.edit");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("UseCaseDiagram.SecondaryLink.delete");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("UseCaseDiagram.UseCase.add");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("UseCaseDiagram.UseCase.edit");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("UseCaseDiagram.UseCase.delete");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);
        
        // view defined actions
        
        // create model element mapping from the domain class diagram view
        pAction = CoreFactory.eINSTANCE.createCreateModelElementMapping();
        pAction.setName("perspective.create.mapping");
        pAction.setForRole("Domain_Model");
        perspective.getActions().add(pAction);
        
        // create model element mapping from the use case diagram view
        pAction = CoreFactory.eINSTANCE.createCreateModelElementMapping();
        pAction.setName("perspective.create.mapping");
        pAction.setForRole("Use_Case");
        perspective.getActions().add(pAction);
    }

    private static void createPerspectiveMappings(COREPerspective perspective) {

        // language element mapping between a domain diagram metaclass and a use case diagram metaclass.
        createLanguageElementMapping(perspective, Cardinality.COMPULSORY, "Domain_Model", 
        		CdmPackage.eINSTANCE.getClassDiagram(), Cardinality.COMPULSORY, "Use_Case", 
        		UcPackage.eINSTANCE.getUseCaseModel());

        // language element mapping between a domain model Class metaclass and a use case model Actor metaclass.
        ElementMapping classActorMapping = createLanguageElementMapping(perspective, Cardinality.COMPULSORY,
                "Domain_Model", CdmPackage.eINSTANCE.getClass_(), Cardinality.OPTIONAL, "Use_Case",
                UcPackage.eINSTANCE.getActor());

        // feature mappings, the name of a class is mapped to the corresponding name of an actor.
        // get the parent mapping type, i.e., the instance of the language element mapping between the container of each
        // feature (e.g., name) to be mapped.
        CORELanguageElementMapping mappingType = classActorMapping.getMappingType();
        
        // get from mapped language element, i.e., the from container of the feature to be mapped.
        CORELanguageElement fromLanguageELement = classActorMapping.getFromLanguageElement();
        
        // get to mapped language element, i.e., the to container of the feature to be mapped.
        CORELanguageElement toLanguageELement = classActorMapping.getToLanguageElement();
        
        // feature mapping, i.e., mapping the name of the domain class to the name of the corresponding actor.
        createNestedMapping(mappingType, fromLanguageELement, toLanguageELement, "name", "name", "Domain_Model", 
                "Use_Case");

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
        mappingType.setIdentifier(PerspectiveDesign.getNextMappingId(perspective));

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
     */
    private static void createNestedMapping(CORELanguageElementMapping mappingType,
            CORELanguageElement fromLanguageElement, CORELanguageElement toLanguageElement, String fromNestedElementName, 
            String toNestedElementName, String fromRoleName, String toRoleName) {

        // from nested language element, which is contained in fromLanguageElement
        CORELanguageElement fromNestedElement = getNestedElement(fromLanguageElement, fromNestedElementName);
        
        // to nested language element, which is contained in toLanguageElement
        CORELanguageElement toNestedElement = getNestedElement(toLanguageElement, toNestedElementName);

        // create the nested mapping
        CORELanguageElementMapping nestedElementMapping = CoreFactory.eINSTANCE.createCORELanguageElementMapping();
        
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
}
