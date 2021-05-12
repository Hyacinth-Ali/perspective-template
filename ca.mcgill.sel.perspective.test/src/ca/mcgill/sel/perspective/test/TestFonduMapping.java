package ca.mcgill.sel.perspective.test;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.sel.amodel.AModel;
import ca.mcgill.sel.amodel.controller.AModelController;
import ca.mcgill.sel.bmodel.BModel;
import ca.mcgill.sel.bmodel.controller.BModelController;
import ca.mcgill.sel.core.COREArtefact;
import ca.mcgill.sel.core.COREExternalArtefact;
import ca.mcgill.sel.core.CORELanguageElementMapping;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREScene;
import ca.mcgill.sel.core.CoreFactory;
import ca.mcgill.sel.core.perspective.COREPerspectiveUtil;

public class TestFonduMapping {

	private static AModelController aModelController;
	private static BModelController bModelController;
	private static COREPerspective perspective;
	private static AModel aModel;
	private static BModel bModel;
	private static COREScene scene;
	private static CORELanguageElementMapping rootMappingType;

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
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, rootMappingType, aModel, bModel, true);
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

		// remove all MEMs
		scene.getElementMappings().clear();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	private static void setUpModels() {
		perspective = TemplateTestPerspective.initializePerspective();
		scene = CoreFactory.eINSTANCE.createCOREScene();
		aModelController = AModelController.getInstance();
		bModelController = BModelController.getInstance();
		aModel = aModelController.getAModel();
		bModel = bModelController.getBModel();

		// create a COREExternalArtefact that refers to the new model and return
		// it
		COREExternalArtefact aModelArtefact = CoreFactory.eINSTANCE.createCOREExternalArtefact();
		aModelArtefact.setRootModelElement(aModel);
		COREExternalArtefact bModelArtefact = CoreFactory.eINSTANCE.createCOREExternalArtefact();
		bModelArtefact.setRootModelElement(bModel);

		EList<COREArtefact> aArtefacts = new BasicEList<COREArtefact>();
		aArtefacts.add(aModelArtefact);
		EList<COREArtefact> bArtefacts = new BasicEList<COREArtefact>();
		bArtefacts.add(bModelArtefact);
		scene.getArtefacts().put("A_Model", aArtefacts);
		scene.getArtefacts().put("B_Model", bArtefacts);

		List<CORELanguageElementMapping> mappingTypes = COREPerspectiveUtil.INSTANCE.getMappingTypes(perspective,
				aModel.eClass(), "A_Model");
		rootMappingType = mappingTypes.get(0);
	}

}
