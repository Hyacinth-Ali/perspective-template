package ca.mcgill.sel.core.perspective.domain.model;

import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREPerspectiveAction;
import ca.mcgill.sel.core.CoreFactory;

public class DomainModelPerspective {

    public static COREPerspective initializePerspective(COREPerspective perspective) {

        // create perspective actions
        createPerspectiveAction(perspective);

        return perspective;
    }

    /**
     * This method creates language actions that are supported by domain modeling.
     * 
     * @author Hyacinth Ali
     * @param perspective - domain model perspective
     */
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

    }
}
