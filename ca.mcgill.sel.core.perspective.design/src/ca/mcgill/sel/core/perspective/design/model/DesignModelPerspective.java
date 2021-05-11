package ca.mcgill.sel.core.perspective.design.model;

import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREPerspectiveAction;
import ca.mcgill.sel.core.CoreFactory;

public class DesignModelPerspective {

    public static COREPerspective initializePerspective(COREPerspective perspective) {

        // create perspective actions
        createPerspectiveAction(perspective);

        return perspective;
    }

    private static void createPerspectiveAction(COREPerspective perspective) {
        // create perspective actions

        COREPerspectiveAction pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("ClassDiagram.Class.add");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("ClassDiagram.Class.edit");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("ClassDiagram.Class.delete");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Note.add");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Note.edit");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Note.delete");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Association.add");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Association.edit");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Association.delete");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.NaryAssociation.add");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.NaryAssociation.delete");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("ClassDiagram.Classifier.Attribute.add");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("ClassDiagram.Classifier.Attribute.edit");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction.setName("ClassDiagram.Classifier.Attribute.delete");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.CDEnum.add");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.CDEnum.edit");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.CDEnum.delete");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.StructuralFeature.static.edit");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.ImplementationClass.add");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.ImplementationClass.edit");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.ImplementationClass.delete");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Classifier.Operation.add");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Classifier.Operation.edit");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Classifier.Operation.delete");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Classifier.Operation.Parameter.add");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Classifier.Operation.Parameter.edit");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.Classifier.Operation.Parameter.delete");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

        pAction = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction.setName("ClassDiagram.VisibilityType.edit");
        pAction.setForRole("Design_Model");
        perspective.getActions().add(pAction);

    }
}
