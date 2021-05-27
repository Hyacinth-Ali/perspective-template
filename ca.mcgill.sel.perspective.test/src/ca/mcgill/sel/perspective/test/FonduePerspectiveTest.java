package ca.mcgill.sel.perspective.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.sel.amodel.A2;
import ca.mcgill.sel.amodel.AModel;
import ca.mcgill.sel.amodel.AmodelPackage;
import ca.mcgill.sel.amodel.controller.AModelController;
import ca.mcgill.sel.bmodel.BModel;
import ca.mcgill.sel.bmodel.BmodelPackage;
import ca.mcgill.sel.bmodel.controller.BModelController;
import ca.mcgill.sel.cmodel.C1;
import ca.mcgill.sel.cmodel.C2;
import ca.mcgill.sel.cmodel.CModel;
import ca.mcgill.sel.cmodel.CmodelPackage;
import ca.mcgill.sel.cmodel.controller.CModelController;
import ca.mcgill.sel.core.COREArtefact;
import ca.mcgill.sel.core.COREExternalArtefact;
import ca.mcgill.sel.core.CORELanguageElementMapping;
import ca.mcgill.sel.core.COREModelElementMapping;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREScene;
import ca.mcgill.sel.core.CoreFactory;
import ca.mcgill.sel.core.perspective.ActionType;
import ca.mcgill.sel.core.perspective.COREPerspectiveUtil;
import ca.mcgill.sel.core.perspective.TemplateType;
import ca.mcgill.sel.perspective.testfonduemapping.RedefinedAModelAction;
import ca.mcgill.sel.perspective.testfonduemapping.RedefinedCModelAction;
import ca.mcgill.sel.ram.ui.perspective.controller.PerspectiveControllerFactory;
import ca.mcgill.sel.ram.ui.perspective.*;

public class FonduePerspectiveTest {

	private static AModelController aModelController;
	private static BModelController bModelController;
	private static CModelController cModelController;
	private static COREPerspective perspective;
	private static AModel aModel;
	private static BModel bModel;
	private static CModel cModel;
	private static COREScene scene;
	private static Map<String, EObject> existingModels;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		setUpModels();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
		// establish root MEM
		createAModel(perspective, scene, "A_Model");
	}

	@After
	public void tearDown() throws Exception {
		// clear elements in the models
		EcoreUtil.deleteAll(aModel.getA1s(), true);
		EcoreUtil.deleteAll(aModel.getA2s(), true);
		EcoreUtil.deleteAll(aModel.getA3s(), true);
		EcoreUtil.deleteAll(aModel.getA4s(), true);
		EcoreUtil.deleteAll(aModel.getA5s(), true);
		EcoreUtil.deleteAll(aModel.getA6s(), true);
		EcoreUtil.deleteAll(aModel.getA7s(), true);
		EcoreUtil.deleteAll(aModel.getA8s(), true);
		EcoreUtil.deleteAll(aModel.getA9s(), true);
		EcoreUtil.deleteAll(aModel.getA10s(), true);
		EcoreUtil.deleteAll(aModel.getA11s(), true);
		EcoreUtil.deleteAll(aModel.getA12s(), true);
//				aModel.eContents().clear();

		EcoreUtil.deleteAll(bModel.getB1s(), true);
		EcoreUtil.deleteAll(bModel.getB2s(), true);
		EcoreUtil.deleteAll(bModel.getB3s(), true);
		EcoreUtil.deleteAll(bModel.getB4s(), true);
		EcoreUtil.deleteAll(bModel.getB5s(), true);
		EcoreUtil.deleteAll(bModel.getB6s(), true);
		EcoreUtil.deleteAll(bModel.getB7s(), true);
		EcoreUtil.deleteAll(bModel.getB8s(), true);
		EcoreUtil.deleteAll(bModel.getB9s(), true);
		EcoreUtil.deleteAll(bModel.getB10s(), true);
		EcoreUtil.deleteAll(bModel.getB11s(), true);
		EcoreUtil.deleteAll(bModel.getB12s(), true);

		EcoreUtil.deleteAll(cModel.getC1s(), true);
		EcoreUtil.deleteAll(cModel.getC2s(), true);
		EcoreUtil.deleteAll(cModel.getC3s(), true);
		EcoreUtil.deleteAll(cModel.getC4s(), true);

		// remove all MEMs
		EcoreUtil.deleteAll(scene.getElementMappings(), true);
		QueryAction.INSTANCE.setCreateMapping(false);
		
	}

	@Test
	public void testCreateA2() {

		aModelController.setComplexAction(true);
		QueryAction.INSTANCE.setNumberOfMapping(5);
//		QueryAction.INSTANCE.setCreateMapping(true);
		RedefinedAModelAction.createNewA2(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA2s().size();
		assertEquals(1, nElements);
		nElements = cModel.getC2s().size();
		assertEquals(5, nElements);
		nElements = cModel.getC1s().size();
		assertEquals(5, nElements);
		nElements = aModel.getA3s().size();
		assertEquals(1, nElements);
		nElements = aModel.getA4s().size();
		assertEquals(1, nElements);
		
		nElements = bModel.getB1s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB3s().size();
		assertEquals(5, nElements);
		
		boolean c1_b1 = checkMapping(cModel.getC1s().get(0), bModel.getB1s().get(0));
		assertTrue(c1_b1);
		boolean a2_c2 = checkMapping(aModel.getA2s().get(0), cModel.getC2s().get(0));
		assertTrue(a2_c2);
	}
	
	
	@Test
	public void testCreateA2WithCreateMapping() {

		aModelController.setComplexAction(true);
		QueryAction.INSTANCE.setNumberOfMapping(5);
		QueryAction.INSTANCE.setCreateMapping(true);
		RedefinedAModelAction.createNewA2(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA2s().size();
		assertEquals(1, nElements);
		nElements = cModel.getC2s().size();
		assertEquals(5, nElements);
		nElements = cModel.getC1s().size();
		assertEquals(1, nElements);
		nElements = aModel.getA3s().size();
		assertEquals(1, nElements);
		nElements = aModel.getA4s().size();
		assertEquals(1, nElements);
		
		nElements = bModel.getB1s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB3s().size();
		assertEquals(5, nElements);
		
		boolean c1_b1 = checkMapping(cModel.getC1s().get(0), bModel.getB1s().get(0));
		assertTrue(c1_b1);
		boolean a2_c2 = checkMapping(aModel.getA2s().get(0), cModel.getC2s().get(0));
		assertTrue(a2_c2);
	}
	
	@Test
	public void testCreateC2() {

		QueryAction.INSTANCE.setNumberOfMapping(5);
		QueryAction.INSTANCE.setCreateMapping(true);
		RedefinedCModelAction.createNewC2(perspective, scene, "C_Model", false, cModel, "name");

		int nElements = cModel.getC2s().size();
		assertEquals(1, nElements);
		nElements = cModel.getC1s().size();
		assertEquals(5, nElements);
		nElements = bModel.getB1s().size();
		assertEquals(1, nElements);
		nElements = aModel.getA2s().size();
		assertEquals(1, nElements);
		nElements = aModel.getA3s().size();
		assertEquals(1, nElements);
		nElements = aModel.getA4s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB3s().size();
		assertEquals(5, nElements);
		
		boolean c1_b1 = checkMapping(cModel.getC1s().get(0), bModel.getB1s().get(0));
		assertTrue(c1_b1);
		boolean a2_c2 = checkMapping(aModel.getA2s().get(0), cModel.getC2s().get(0));
		assertTrue(a2_c2);
	}
	
	@Test
	public void testDeleteA2() {

		aModelController.setComplexAction(true);
		QueryAction.INSTANCE.setNumberOfMapping(5);
		RedefinedAModelAction.createNewA2(perspective, scene, "A_Model", false, aModel, "name");

		
		int nElements = aModel.getA2s().size();
		assertEquals(1, nElements);
		nElements = cModel.getC2s().size();
		assertEquals(5, nElements);
		nElements = cModel.getC1s().size();
		assertEquals(5, nElements);
		nElements = aModel.getA3s().size();
		assertEquals(1, nElements);
		nElements = aModel.getA4s().size();
		assertEquals(1, nElements);
		
		A2 a2 = aModel.getA2s().get(0);
		RedefinedAModelAction.deleteA2(perspective, scene, "A_Model", a2);
		
		nElements = aModel.getA2s().size();
		assertEquals(0, nElements);
		nElements = cModel.getC2s().size();
		assertEquals(0, nElements);
		

	}
	
	@Test
	public void testDeleteA2ComplexAction() {

		aModelController.setComplexAction(true);
		QueryAction.INSTANCE.setNumberOfMapping(5);
		RedefinedAModelAction.createNewA2(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA2s().size();
		assertEquals(1, nElements);
		nElements = cModel.getC2s().size();
		assertEquals(5, nElements);
		nElements = cModel.getC1s().size();
		assertEquals(5, nElements);
		nElements = aModel.getA3s().size();
		assertEquals(1, nElements);
		nElements = aModel.getA4s().size();
		assertEquals(1, nElements);
		
		nElements = bModel.getB1s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB3s().size();
		assertEquals(5, nElements);
		
		boolean c1_b1 = checkMapping(cModel.getC1s().get(0), bModel.getB1s().get(0));
		assertTrue(c1_b1);
		boolean a2_c2 = checkMapping(aModel.getA2s().get(0), cModel.getC2s().get(0));
		assertTrue(a2_c2);
		
		A2 a2 = aModel.getA2s().get(0);
		RedefinedAModelAction.deleteA2(perspective, scene, "A_Model", a2);
		
		nElements = aModel.getA2s().size();
		assertEquals(0, nElements);
		nElements = cModel.getC2s().size();
		assertEquals(0, nElements);
		nElements = cModel.getC1s().size();
		assertEquals(5, nElements);
		nElements = aModel.getA3s().size();
		assertEquals(0, nElements);
		nElements = aModel.getA4s().size();
		assertEquals(0, nElements);
		nElements = bModel.getB1s().size();
		assertEquals(0, nElements);
		nElements = bModel.getB3s().size();
		assertEquals(5, nElements);

		

	}
	
	@Test
	public void testDeleteC2() {

		QueryAction.INSTANCE.setNumberOfMapping(5);
		QueryAction.INSTANCE.setCreateMapping(true);
		RedefinedCModelAction.createNewC2(perspective, scene, "C_Model", false, cModel, "name");

		int nElements = cModel.getC2s().size();
		assertEquals(1, nElements);
		nElements = cModel.getC1s().size();
		assertEquals(5, nElements);
		nElements = bModel.getB1s().size();
		assertEquals(1, nElements);
		nElements = aModel.getA2s().size();
		assertEquals(1, nElements);
		nElements = aModel.getA3s().size();
		assertEquals(1, nElements);
		nElements = aModel.getA4s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB3s().size();
		assertEquals(5, nElements);
		
		C2 c2 = cModel.getC2s().get(0);
		RedefinedCModelAction.deleteC2(perspective, scene, "C_Model", c2);
		
		nElements = cModel.getC2s().size();
		assertEquals(0, nElements);
		nElements = aModel.getA2s().size();
		assertEquals(0, nElements);
		nElements = cModel.getC1s().size();
		assertEquals(5, nElements);
		nElements = aModel.getA3s().size();
		assertEquals(0, nElements);
		nElements = aModel.getA4s().size();
		assertEquals(0, nElements);
		nElements = bModel.getB1s().size();
		assertEquals(0, nElements);
		nElements = bModel.getB3s().size();
		assertEquals(5, nElements);
	}
	
	@Test
	public void testUpdateA2() {
		
		aModelController.setComplexAction(true);
		QueryAction.INSTANCE.setNumberOfMapping(5);
		RedefinedAModelAction.createNewA2(perspective, scene, "A_Model", false, aModel, "name");

		PerspectiveControllerFactory.INSTANCE.getBasePerspectiveController().updateElement(perspective, scene,
				"A_Model", aModel.getA2s().get(0), AmodelPackage.eINSTANCE.getNamedElement_Name(), "name2");
		
		String newName = null;
		newName = aModel.getA2s().get(0).getName();
		assertEquals("name2", newName);
		for (C2 c : cModel.getC2s()) {
			newName = c.getName();
			assertEquals("name2", newName);
		}
		

	}
	
	@Test
	public void testUpdateA4() {
		
		aModelController.setComplexAction(true);
		QueryAction.INSTANCE.setNumberOfMapping(5);
		RedefinedAModelAction.createNewA4(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA4s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB1s().size();
		assertEquals(1, nElements);
		nElements = cModel.getC1s().size();
		assertEquals(5, nElements);
		
		PerspectiveControllerFactory.INSTANCE.getBasePerspectiveController().updateElement(perspective, scene,
				"A_Model", aModel.getA4s().get(0), AmodelPackage.eINSTANCE.getNamedElement_Name(), "name2");
		
		String newName = null;
		newName = aModel.getA4s().get(0).getName();
		assertEquals("name2", newName);
		newName = bModel.getB1s().get(0).getName();
		assertEquals("name2", newName);
		for (C1 c : cModel.getC1s()) {
			newName = c.getName();
			assertEquals("name2", newName);
		}
		
	}

	private static boolean checkMapping(EObject fromElement, EObject toElement) {
		boolean mappingExist = false;
		for (COREModelElementMapping mapping : scene.getElementMappings()) {
			EObject e1 = mapping.getModelElements().get(0);
			EObject e2 = mapping.getModelElements().get(1);
			if (e1.equals(fromElement) && e2.equals(toElement)) {
				mappingExist = true;
			} else if (e1.equals(toElement) && e2.equals(fromElement)) {
				mappingExist = true;
			}
		}
		return mappingExist;
		
	}

	private static void setUpModels() {
		existingModels = new HashMap<String, EObject>();
		perspective = TestFonduEPerspective.initializePerspective();
		scene = CoreFactory.eINSTANCE.createCOREScene();
		aModelController = AModelController.getInstance();
		bModelController = BModelController.getInstance();
		cModelController = CModelController.getInstance();
		createAModel(perspective, scene, "A_Model");

		COREExternalArtefact aModelArtefact = CoreFactory.eINSTANCE.createCOREExternalArtefact();
		aModelArtefact.setRootModelElement(aModel);
		COREExternalArtefact bModelArtefact = CoreFactory.eINSTANCE.createCOREExternalArtefact();
		bModelArtefact.setRootModelElement(bModel);
		COREExternalArtefact cModelArtefact = CoreFactory.eINSTANCE.createCOREExternalArtefact();
		cModelArtefact.setRootModelElement(cModel);

		EList<COREArtefact> aArtefacts = new BasicEList<COREArtefact>();
		aArtefacts.add(aModelArtefact);
		EList<COREArtefact> bArtefacts = new BasicEList<COREArtefact>();
		bArtefacts.add(bModelArtefact);
		EList<COREArtefact> cArtefacts = new BasicEList<COREArtefact>();
		cArtefacts.add(cModelArtefact);
		scene.getArtefacts().put("A_Model", aArtefacts);
		scene.getArtefacts().put("B_Model", bArtefacts);
		scene.getArtefacts().put("C_Model", cArtefacts);

	}

	public static void createAModel(COREPerspective perspective, COREScene scene, String currentRole) {

		// primary language action to create a new class
		aModel = aModelController.getAModel();
		createOtherElementsForAModel(perspective, scene, currentRole, aModel);
		// clear existing role names
		existingModels.clear();

	}

	public static void createOtherElementsForAModel(COREPerspective perspective, COREScene scene,
			String currentRoleName, EObject currentModel) throws PerspectiveException {

		existingModels.put(currentRoleName, currentModel);
		List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
				currentModel.eClass(), currentRoleName);
		for (CORELanguageElementMapping mappingType : mappingTypes) {
			List<COREModelElementMapping> mappings = COREPerspectiveUtil.INSTANCE.getMappings(mappingType, scene,
					currentModel);

			// other role names, i.e., excluding the current role
			String otherRoleName = COREPerspectiveUtil.INSTANCE.getOtherRoleName(mappingType, currentRoleName);

			// the metaclass of the element to be created.
			EObject otherLE = COREPerspectiveUtil.INSTANCE
					.getOtherLanguageElements(mappingType, currentModel.eClass(), currentRoleName).get(0);

			ActionType actionType = TemplateType.INSTANCE.getCreateType(mappingType, currentRoleName);

			// check that the number of existing mappings is not zero.
			if (mappings.size() != 0) {
				continue;
			}
			switch (actionType) {

			// C2
			case CREATE:
				createElementForAModel(perspective, mappingType, scene, currentModel, currentRoleName, otherRoleName,
						otherLE);
				break;
			}
		}
	}

	private static void createElementForAModel(COREPerspective perspective, CORELanguageElementMapping mappingType,
			COREScene scene, EObject currentElement, String currentRoleName, String otherRoleName, EObject otherLE) {
		EObject otherModel = findExistingNewModel(otherRoleName);
		if (otherModel == null) {
			if (otherLE.equals(BmodelPackage.eINSTANCE.getBModel())) {
				bModel = bModelController.getBModel();
				COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, bModel,
						false);
				createOtherElementsForAModel(perspective, scene, otherRoleName, bModel);
			} else if (otherLE.equals(CmodelPackage.eINSTANCE.getCModel())) {
				cModel = cModelController.getCModel();
				COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, cModel,
						false);
				createOtherElementsForAModel(perspective, scene, otherRoleName, cModel);
			}
		} else {
			if (otherLE.equals(BmodelPackage.eINSTANCE.getBModel())) {
				COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, bModel,
						false);
			} else if (otherLE.equals(CmodelPackage.eINSTANCE.getCModel())) {
				COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, cModel,
						false);
			} else if (otherLE.equals(AmodelPackage.eINSTANCE.getAModel())) {
				COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, mappingType, currentElement, aModel,
						false);
			}
		}

	}

	/**
	 * Checks if a model with the role "role" already exist.
	 * 
	 * @param role - the role of the model
	 * @return the model
	 */
	private static EObject findExistingNewModel(String role) {
		EObject existingModel = null;
		for (Map.Entry<String, EObject> entry : existingModels.entrySet()) {
			String key = entry.getKey();
			if (key.equals(role)) {
				existingModel = entry.getValue();
				break;
			}
		}
		return existingModel;
	}

}
