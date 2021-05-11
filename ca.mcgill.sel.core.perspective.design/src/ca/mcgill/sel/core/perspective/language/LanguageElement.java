package ca.mcgill.sel.core.perspective.language;

import ca.mcgill.sel.core.CORELanguageElement;

public class LanguageElement {

    private static CORELanguageElement classElement;
    private static CORELanguageElement actorElement;
    
    /**
     * @return the classElement
     */
    public static CORELanguageElement getClassElement() {
        return classElement;
    }

    /**
     * @param classElement the classElement to set
     */
    public static void setClassElement() {
        // create language classElement
//        CORELanguageElement clazz = CoreFactory.eINSTANCE.createCORELanguageElement();
//        clazz.setLanguageElement(CdmPackage.eINSTANCE.getClass_());
//        clazz.setCreateClassQualifiedName("ca.mcgill.sel.classdiagram.controller.ClassDiagramController");
//        clazz.setCreateMethodName("createNewClass");
//        classElement = clazz;
    }
    
    /**
     * @return the actorElement
     */
    public static CORELanguageElement getActorElement() {
        return actorElement;
    }

    /**
     * @param classElement the classElement to set
     */
    public static void setActorElement() {
        // create language classElement
//        CORELanguageElement actor = CoreFactory.eINSTANCE.createCORELanguageElement();
//        actor.setLanguageElement(UcdmPackage.eINSTANCE.getActor());
//        actor.setCreateClassQualifiedName("ca.mcgill.sel.usecasediagram.controller.UseCaseDiagramController");
//        actor.setCreateMethodName("createNewActor");
//        actorElement = actor;
        
    }
}
