package ca.mcgill.sel.core.perspective.usecase;

import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREPerspectiveAction;
import ca.mcgill.sel.core.CoreFactory;

public class UseCasePerspective {

    public static COREPerspective initializePerspective(COREPerspective perspective) {

        // create perspective actions
        createPerspectiveAction(perspective);

        return perspective;
    }

    private static void createPerspectiveAction(COREPerspective perspective) {
        // create perspective actions

        COREPerspectiveAction pAction = CoreFactory.eINSTANCE.createCORERedefineAction();
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

    }
}
