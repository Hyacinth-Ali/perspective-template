package ca.mcgill.sel.core.perspective.domain.design.models;

import ca.mcgill.sel.classdiagram.CdmPackage;
import ca.mcgill.sel.core.COREConcern;
import ca.mcgill.sel.core.CORELanguageElement;
import ca.mcgill.sel.core.CORELanguageElementMapping;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREPerspectiveAction;
import ca.mcgill.sel.core.CORERelationship;
import ca.mcgill.sel.core.Cardinality;
import ca.mcgill.sel.core.CoreFactory;
import ca.mcgill.sel.core.MappingEnd;
import ca.mcgill.sel.core.perspective.language.LanguageElement;
import ca.mcgill.sel.core.util.COREModelUtil;
import ca.mcgill.sel.usecases.UcPackage;

public class DomainModelDesignModelPerspective {
    
    public static COREPerspective createPerspective() {

        // create perspective concern
        COREConcern perspectiveConcern = COREModelUtil.createConcern("DomainModel_DesignModel");
    
        COREPerspective perspective = CoreFactory.eINSTANCE.createCOREPerspective();
        perspective.setName("DomainModel_DesignModel_Gen");
        //perspective.setDefault("Domain_Model");
    
        // create perspective actions
        
        COREPerspectiveAction pAction1 = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction1.setName("ClassDiagram.Class.add"); 
        pAction1.setForRole("Domain_Model");   
        perspective.getActions().add(pAction1); 
        
        COREPerspectiveAction pAction2 = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction2.setName("ClassDiagram.Class.edit"); 
        pAction2.setForRole("Domain_Model");   
        perspective.getActions().add(pAction2); 
        
        COREPerspectiveAction pAction3 = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction3.setName("ClassDiagram.Class.delete"); 
        pAction3.setForRole("Domain_Model");   
        perspective.getActions().add(pAction3); 
        
        COREPerspectiveAction pAction4 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction4.setName("ClassDiagram.Note.add"); 
        pAction4.setForRole("Domain_Model");   
        perspective.getActions().add(pAction4); 
        
        COREPerspectiveAction pAction5 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction5.setName("ClassDiagram.Note.edit"); 
        pAction5.setForRole("Domain_Model");   
        perspective.getActions().add(pAction5); 
        
        COREPerspectiveAction pAction6 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction6.setName("ClassDiagram.Note.delete"); 
        pAction6.setForRole("Domain_Model");   
        perspective.getActions().add(pAction6); 
        
        COREPerspectiveAction pAction7 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction7.setName("ClassDiagram.Association.add"); 
        pAction7.setForRole("Domain_Model");   
        perspective.getActions().add(pAction7); 
        
        COREPerspectiveAction pAction8 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction8.setName("ClassDiagram.Association.edit"); 
        pAction8.setForRole("Domain_Model");   
        perspective.getActions().add(pAction8); 
        
        COREPerspectiveAction pAction9 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction9.setName("ClassDiagram.Association.delete"); 
        pAction9.setForRole("Domain_Model");   
        perspective.getActions().add(pAction9); 
        
        COREPerspectiveAction pAction10 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction10.setName("ClassDiagram.NaryAssociation.add"); 
        pAction10.setForRole("Domain_Model");   
        perspective.getActions().add(pAction10); 
        
        COREPerspectiveAction pAction11 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction11.setName("ClassDiagram.NaryAssociation.delete"); 
        pAction11.setForRole("Domain_Model");   
        perspective.getActions().add(pAction11); 
        
        COREPerspectiveAction pAction12 = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction12.setName("ClassDiagram.Classifier.Attribute.add"); 
        pAction12.setForRole("Domain_Model");   
        perspective.getActions().add(pAction12); 
        
        COREPerspectiveAction pAction13 = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction13.setName("ClassDiagram.Classifier.Attribute.edit"); 
        pAction13.setForRole("Domain_Model");   
        perspective.getActions().add(pAction13); 
        
        COREPerspectiveAction pAction14 = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction14.setName("ClassDiagram.Classifier.Attribute.delete"); 
        pAction14.setForRole("Domain_Model");   
        perspective.getActions().add(pAction14); 
        
        COREPerspectiveAction pAction15 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction15.setName("ClassDiagram.CDEnum.add"); 
        pAction15.setForRole("Domain_Model");   
        perspective.getActions().add(pAction15); 
        
        COREPerspectiveAction pAction16 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction16.setName("ClassDiagram.CDEnum.edit"); 
        pAction16.setForRole("Domain_Model");   
        perspective.getActions().add(pAction16); 
        
        COREPerspectiveAction pAction17 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction17.setName("ClassDiagram.CDEnum.delete"); 
        pAction17.setForRole("Domain_Model");   
        perspective.getActions().add(pAction17); 
        
        COREPerspectiveAction pAction18 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction18.setName("ClassDiagram.StructuralFeature.static.edit"); 
        pAction18.setForRole("Domain_Model");   
        perspective.getActions().add(pAction18); 
        
        COREPerspectiveAction pAction19 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction19.setName("ClassDiagram.VisibilityType.edit"); 
        pAction19.setForRole("Domain_Model");   
        perspective.getActions().add(pAction19); 
        
        COREPerspectiveAction pAction20 = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction20.setName("ClassDiagram.Class.add"); 
        pAction20.setForRole("Design_Model");   
        perspective.getActions().add(pAction20); 
        
        COREPerspectiveAction pAction21 = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction21.setName("ClassDiagram.Class.edit"); 
        pAction21.setForRole("Design_Model");   
        perspective.getActions().add(pAction21); 
        
        COREPerspectiveAction pAction22 = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction22.setName("ClassDiagram.Class.delete"); 
        pAction22.setForRole("Design_Model");   
        perspective.getActions().add(pAction22); 
        
        COREPerspectiveAction pAction23 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction23.setName("ClassDiagram.Note.add"); 
        pAction23.setForRole("Design_Model");   
        perspective.getActions().add(pAction23); 
        
        COREPerspectiveAction pAction24 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction24.setName("ClassDiagram.Note.edit"); 
        pAction24.setForRole("Design_Model");   
        perspective.getActions().add(pAction24); 
        
        COREPerspectiveAction pAction25 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction25.setName("ClassDiagram.Note.delete"); 
        pAction25.setForRole("Design_Model");   
        perspective.getActions().add(pAction25); 
        
        COREPerspectiveAction pAction26 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction26.setName("ClassDiagram.Association.add"); 
        pAction26.setForRole("Design_Model");   
        perspective.getActions().add(pAction26); 
        
        COREPerspectiveAction pAction27 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction27.setName("ClassDiagram.Association.edit"); 
        pAction27.setForRole("Design_Model");   
        perspective.getActions().add(pAction27); 
        
        COREPerspectiveAction pAction28 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction28.setName("ClassDiagram.Association.delete"); 
        pAction28.setForRole("Design_Model");   
        perspective.getActions().add(pAction28); 
        
        COREPerspectiveAction pAction29 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction29.setName("ClassDiagram.NaryAssociation.add"); 
        pAction29.setForRole("Design_Model");   
        perspective.getActions().add(pAction29); 
        
        COREPerspectiveAction pAction30 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction30.setName("ClassDiagram.NaryAssociation.delete"); 
        pAction30.setForRole("Design_Model");   
        perspective.getActions().add(pAction30); 
        
        COREPerspectiveAction pAction31 = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction31.setName("ClassDiagram.Classifier.Attribute.add"); 
        pAction31.setForRole("Design_Model");   
        perspective.getActions().add(pAction31); 
        
        COREPerspectiveAction pAction32 = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction32.setName("ClassDiagram.Classifier.Attribute.edit"); 
        pAction32.setForRole("Design_Model");   
        perspective.getActions().add(pAction32); 
        
        COREPerspectiveAction pAction33 = CoreFactory.eINSTANCE.createCORERedefineAction();
        pAction33.setName("ClassDiagram.Classifier.Attribute.delete"); 
        pAction33.setForRole("Design_Model");   
        perspective.getActions().add(pAction33); 
        
        COREPerspectiveAction pAction34 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction34.setName("ClassDiagram.CDEnum.add"); 
        pAction34.setForRole("Design_Model");   
        perspective.getActions().add(pAction34); 
        
        COREPerspectiveAction pAction35 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction35.setName("ClassDiagram.CDEnum.edit"); 
        pAction35.setForRole("Design_Model");   
        perspective.getActions().add(pAction35); 
        
        COREPerspectiveAction pAction36 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction36.setName("ClassDiagram.CDEnum.delete"); 
        pAction36.setForRole("Design_Model");   
        perspective.getActions().add(pAction36); 
        
        COREPerspectiveAction pAction37 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction37.setName("ClassDiagram.StructuralFeature.static.edit"); 
        pAction37.setForRole("Design_Model");   
        perspective.getActions().add(pAction37); 
        
        COREPerspectiveAction pAction38 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction38.setName("ClassDiagram.ImplementationClass.add"); 
        pAction38.setForRole("Design_Model");   
        perspective.getActions().add(pAction38); 
        
        COREPerspectiveAction pAction39 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction39.setName("ClassDiagram.ImplementationClass.edit"); 
        pAction39.setForRole("Design_Model");   
        perspective.getActions().add(pAction39); 
        
        COREPerspectiveAction pAction40 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction40.setName("ClassDiagram.ImplementationClass.delete"); 
        pAction40.setForRole("Design_Model");   
        perspective.getActions().add(pAction40); 
        
        COREPerspectiveAction pAction41 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction41.setName("ClassDiagram.Classifier.Operation.add"); 
        pAction41.setForRole("Design_Model");   
        perspective.getActions().add(pAction41); 
        
        COREPerspectiveAction pAction42 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction42.setName("ClassDiagram.Classifier.Operation.edit"); 
        pAction42.setForRole("Design_Model");   
        perspective.getActions().add(pAction42); 
        
        COREPerspectiveAction pAction43 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction43.setName("ClassDiagram.Classifier.Operation.delete"); 
        pAction43.setForRole("Design_Model");   
        perspective.getActions().add(pAction43); 
        
        COREPerspectiveAction pAction44 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction44.setName("ClassDiagram.Classifier.Operation.Parameter.add"); 
        pAction44.setForRole("Design_Model");   
        perspective.getActions().add(pAction44); 
        
        COREPerspectiveAction pAction45 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction45.setName("ClassDiagram.Classifier.Operation.Parameter.edit"); 
        pAction45.setForRole("Design_Model");   
        perspective.getActions().add(pAction45); 
        
        COREPerspectiveAction pAction46 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction46.setName("ClassDiagram.Classifier.Operation.Parameter.delete"); 
        pAction46.setForRole("Design_Model");   
        perspective.getActions().add(pAction46); 
        
        COREPerspectiveAction pAction47 = CoreFactory.eINSTANCE.createCOREReexposeAction();
        pAction47.setName("ClassDiagram.VisibilityType.edit"); 
        pAction47.setForRole("Design_Model");   
        perspective.getActions().add(pAction47); 
        
        // create language element
//        LanguageElement.setClassElement();
//        CORELanguageElement fromClazz = LanguageElement.getClassElement();
//        CORELanguageElement toClazz = LanguageElement.getClassElement();
        

    // create perspective templates
        // correct the indentation in the code generator
     
    CORELanguageElementMapping mapType = CoreFactory.eINSTANCE.createCORELanguageElementMapping();
    mapType.setIdentifier(PerspectiveDesign.getNextMappingId(perspective));
    
    MappingEnd mappingEnd1 = CoreFactory.eINSTANCE.createMappingEnd(); 
    mappingEnd1.setCardinality(Cardinality.COMPULSORY);
    mappingEnd1.setRoleName("Domain_Model");
    mappingEnd1.getLanguageElement().setLanguageElement(CdmPackage.eINSTANCE.getClass_());
                 
    MappingEnd mappingEnd2 = CoreFactory.eINSTANCE.createMappingEnd();
    mappingEnd2.setCardinality(Cardinality.OPTIONAL);
    mappingEnd2.setRoleName("Design_Model");
    mappingEnd2.getLanguageElement().setLanguageElement(UcPackage.eINSTANCE.getActor());
    
    mapType.getMappingEnds().add(mappingEnd1);
    mapType.getMappingEnds().add(mappingEnd2);
    perspective.getMappings().add(mapType); 
        
    perspectiveConcern.getArtefacts().add(perspective);
    
    return perspective;

  }
}

