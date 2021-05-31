package ca.mcgill.sel.perspective.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.sel.amodel.A4;
import ca.mcgill.sel.amodel.AModel;
import ca.mcgill.sel.amodel.AmodelPackage;
import ca.mcgill.sel.amodel.controller.AModelController;
import ca.mcgill.sel.bmodel.B11;
import ca.mcgill.sel.bmodel.BModel;
import ca.mcgill.sel.bmodel.controller.BModelController;
import ca.mcgill.sel.core.COREArtefact;
import ca.mcgill.sel.core.COREExternalArtefact;
import ca.mcgill.sel.core.CORELanguageElementMapping;
import ca.mcgill.sel.core.COREPerspective;
import ca.mcgill.sel.core.COREScene;
import ca.mcgill.sel.core.CoreFactory;
import ca.mcgill.sel.core.perspective.COREPerspectiveUtil;
import ca.mcgill.sel.ram.ui.perspective.controller.PerspectiveControllerFactory;
import ca.mcgill.sel.ram.ui.perspective.*;
import ca.mcgill.sel.perspective.perspectivetest.*;

public class TemplateMainTest {

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
		COREPerspectiveUtil.INSTANCE.createMapping(perspective, scene, rootMappingType, aModel, bModel, false);

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
//		aModel.eContents().clear();

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

	// Create tests

	/**
	 * C1: primary multiplicity (1) - other multiplicity (0..1)
	 */
	@Test
	public void testCanCreateElement() {

		// Assuming the user decides not to create mapping after creating A1
		// element
		QueryAction.INSTANCE.setCreateMapping(false);
		RedefinedAModelLanguageAction.createNewA1(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA1s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB1s().size();
		assertEquals(0, nElements);

		// Assuming the user decides to create mapping after creating A1 element
		QueryAction.INSTANCE.setCreateMapping(true);
		RedefinedAModelLanguageAction.createNewA1(perspective, scene, "A_Model", false, aModel, "name");

		nElements = aModel.getA1s().size();
		assertEquals(2, nElements);
		nElements = bModel.getB1s().size();
		assertEquals(1, nElements);
	}

	/**
	 * C1: primary multiplicity (1) - other multiplicity (0..1)
	 */
	@Test
	public void testCanCreateElementComplexAction() {

		aModelController.setComplexAction(true);
		QueryAction.INSTANCE.setNumberOfMapping(2);
		QueryAction.INSTANCE.setCreateMapping(true);
		// creating A1 creates A2, A3, and A4 if each doesn't exist
		RedefinedAModelLanguageAction.createNewA1(perspective, scene, "A_Model", false, aModel, "name");
		aModelController.setComplexAction(false);
		
		int nElements = aModel.getA1s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB1s().size();
		assertEquals(1, nElements);
		
		nElements = aModel.getA2s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB2s().size();
		assertEquals(1, nElements);
		
		nElements = aModel.getA3s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB3s().size();
		assertEquals(2, nElements);
	}

	/**
	 * C2: primary multiplicity (1) - other multiplicity (1)
	 */
	@Test
	public void testCreateElement() {

		RedefinedAModelLanguageAction.createNewA2(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA2s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB2s().size();
		assertEquals(aModel.getA2s().get(0).getName(), bModel.getB2s().get(0).getName());
		assertEquals(1, nElements);

	}

	/**
	 * C3: primary multiplicity (1) - other multiplicity (0..*)
	 */
	@Test
	public void testCanCreateManyElements() {

		// Assuming the user decides not to create mapping after creating A3
		// element
		QueryAction.INSTANCE.setNumberOfMapping(0);
		RedefinedAModelLanguageAction.createNewA3(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA3s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB3s().size();
		assertEquals(0, nElements);

		// Assuming the user decides to create one mapping after creating A3
		// element
		QueryAction.INSTANCE.setNumberOfMapping(1);
		RedefinedAModelLanguageAction.createNewA3(perspective, scene, "A_Model", false, aModel, "name");

		nElements = aModel.getA3s().size();
		assertEquals(2, nElements);
		nElements = bModel.getB3s().size();
		assertEquals(1, nElements);

		// Assuming the user decides to create five mappings after creating A3
		// element
		QueryAction.INSTANCE.setNumberOfMapping(5);
		RedefinedAModelLanguageAction.createNewA3(perspective, scene, "A_Model", false, aModel, "name");

		nElements = aModel.getA3s().size();
		assertEquals(3, nElements);
		nElements = bModel.getB3s().size();
		assertEquals(6, nElements);
	}

	/**
	 * C4: primary multiplicity (1) - other multiplicity (1..*)
	 */
	@Test
	public void testCreateAtLeastOneElement() {

		// Assuming the user decides to create one mapping after creating A4
		// element
		QueryAction.INSTANCE.setNumberOfMapping(1);
		RedefinedAModelLanguageAction.createNewA4(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA4s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB4s().size();
		assertEquals(1, nElements);

		// Assuming the user decides to create six mappings after creating A4
		// element
		QueryAction.INSTANCE.setNumberOfMapping(6);
		RedefinedAModelLanguageAction.createNewA4(perspective, scene, "A_Model", false, aModel, "name");

		nElements = aModel.getA4s().size();
		assertEquals(2, nElements);
		nElements = bModel.getB4s().size();
		assertEquals(7, nElements);

	}

	/**
	 * C5: primary multiplicity (0..* or 1..*) - other multiplicity (0..1)
	 */
	@Test
	public void testCanCreateOrUseElement() {

		// Assuming the user decides not to create mapping after creating A5
		// element
		QueryAction.INSTANCE.setCreateMapping(false);
		RedefinedAModelLanguageAction.createNewA5(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA5s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB5s().size();
		assertEquals(0, nElements);

		// Assuming the user decides to create a mapping after creating A5
		// element
		// and there is no existing B5 element
		QueryAction.INSTANCE.setCreateMapping(true);
		RedefinedAModelLanguageAction.createNewA5(perspective, scene, "A_Model", false, aModel, "name");

		nElements = aModel.getA5s().size();
		assertEquals(2, nElements);
		nElements = bModel.getB5s().size();
		assertEquals(1, nElements);

		// Assuming the user decides to create a mapping after creating A5
		// element
		// and there is existing B5 element
		QueryAction.INSTANCE.setCreateMapping(true);
		// create element A1
		RedefinedAModelLanguageAction.createNewA5(perspective, scene, "A_Model", false, aModel, "name");

		nElements = aModel.getA5s().size();
		assertEquals(3, nElements);
		nElements = bModel.getB5s().size();
		assertEquals(1, nElements);
	}

	/**
	 * C6: primary multiplicity (0..* or 1..*) - other multiplicity (1)
	 */
	@Test
	public void testCreateOrUseElement() {

		// There is no corresponding element
		RedefinedAModelLanguageAction.createNewA6(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA6s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB6s().size();
		assertEquals(1, nElements);

		// Now, there is a corresponding B element
		RedefinedAModelLanguageAction.createNewA6(perspective, scene, "A_Model", false, aModel, "name");

		nElements = aModel.getA6s().size();
		assertEquals(2, nElements);
		nElements = bModel.getB6s().size();
		assertEquals(1, nElements);

		// Here, there is no corresponding element, because of "name2" instead
		// of "name"
		RedefinedAModelLanguageAction.createNewA6(perspective, scene, "A_Model", false, aModel, "name2");

		nElements = aModel.getA6s().size();
		assertEquals(3, nElements);
		nElements = bModel.getB6s().size();
		assertEquals(2, nElements);
	}

	/**
	 * C7: primary multiplicity (0..* or 1..*) - other multiplicity (0..*)
	 */
	@Test
	public void testCanCreateOrUseManyElements() {

		// Assuming the user decides not to create mapping after creating A7
		// element
		QueryAction.INSTANCE.setNumberOfMapping(0);
		RedefinedAModelLanguageAction.createNewA7(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA7s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB7s().size();
		assertEquals(0, nElements);

		// Assuming the user decides to create mappings after creating A7
		// element
		// and there is no existing B7 element
		QueryAction.INSTANCE.setNumberOfMapping(5);
		RedefinedAModelLanguageAction.createNewA7(perspective, scene, "A_Model", false, aModel, "name");

		nElements = aModel.getA7s().size();
		assertEquals(2, nElements);
		nElements = bModel.getB7s().size();
		assertEquals(5, nElements);

		// Assuming the user decides to create mapping after creating A7 element
		// and there is existing B7 elements
		QueryAction.INSTANCE.setNumberOfMapping(8);
		RedefinedAModelLanguageAction.createNewA7(perspective, scene, "A_Model", false, aModel, "name");

		nElements = aModel.getA7s().size();
		assertEquals(3, nElements);
		nElements = bModel.getB7s().size();
		assertEquals(8, nElements);
	}

	/**
	 * C8: primary multiplicity (0..* or 1..*) - other multiplicity (1..*)
	 */
	@Test
	public void testCreateOrUseAtLeastOneElement() {

		QueryAction.INSTANCE.setNumberOfMapping(1);
		RedefinedAModelLanguageAction.createNewA8(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA8s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB8s().size();
		assertEquals(1, nElements);

		// Assuming the user decides to create 5 mappings after creating A8
		// element
		// and there is one existing B8 element (hence, 4 new elements are
		// created)
		QueryAction.INSTANCE.setNumberOfMapping(5);
		RedefinedAModelLanguageAction.createNewA8(perspective, scene, "A_Model", false, aModel, "name");

		nElements = aModel.getA8s().size();
		assertEquals(2, nElements);
		nElements = bModel.getB8s().size();
		assertEquals(5, nElements);

		// Assuming the user decides to create 8 mappings after creating A1
		// element
		// and the existing B elements do match to be mapped, "name2"
		QueryAction.INSTANCE.setNumberOfMapping(8);
		RedefinedAModelLanguageAction.createNewA8(perspective, scene, "A_Model", false, aModel, "name2");

		nElements = aModel.getA8s().size();
		assertEquals(3, nElements);
		nElements = bModel.getB8s().size();
		assertEquals(13, nElements);
	}

	/**
	 * C9: primary multiplicity (0..1) - other multiplicity (0..1)
	 */
	@Test
	public void testCanCreateOrUseNonMappedElement() {

		// Assuming the user decides not to create mapping after creating A9
		// element
		QueryAction.INSTANCE.setCreateMapping(false);
		RedefinedAModelLanguageAction.createNewA9(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA9s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB9s().size();
		assertEquals(0, nElements);

		// Assuming the user decides to create mapping after creating A9 element
		// and there is no existing B9 element
		QueryAction.INSTANCE.setCreateMapping(true);
		RedefinedAModelLanguageAction.createNewA9(perspective, scene, "A_Model", false, aModel, "name");

		nElements = aModel.getA9s().size();
		assertEquals(2, nElements);
		nElements = bModel.getB9s().size();
		assertEquals(1, nElements);

		// Assuming the user decides to create mapping after creating A9 element
		// and there is existing B9 element which is mapped
		QueryAction.INSTANCE.setCreateMapping(true);
		RedefinedAModelLanguageAction.createNewA9(perspective, scene, "A_Model", false, aModel, "name");

		nElements = aModel.getA9s().size();
		assertEquals(3, nElements);
		nElements = bModel.getB9s().size();
		assertEquals(2, nElements);

		// Assuming the user decides to create mapping after creating A9 element
		// and there is a corresponding B element which is not mapped
		bModelController.createB9(bModel, "name2");
		QueryAction.INSTANCE.setCreateMapping(true);
		RedefinedAModelLanguageAction.createNewA9(perspective, scene, "A_Model", false, aModel, "name2");

		nElements = aModel.getA9s().size();
		assertEquals(4, nElements);
		nElements = bModel.getB9s().size();
		assertEquals(3, nElements);
	}

	/**
	 * C10: primary multiplicity (0..1) - other multiplicity (1)
	 */
	@Test
	public void testCreateOrUseNonMappedElement() {

		RedefinedAModelLanguageAction.createNewA10(perspective, scene, "A_Model", false, aModel, "name");
		int nElements = aModel.getA10s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB10s().size();
		assertEquals(1, nElements);

		// There is existing B10 element which is mapped
		RedefinedAModelLanguageAction.createNewA10(perspective, scene, "A_Model", false, aModel, "name");

		nElements = aModel.getA10s().size();
		assertEquals(2, nElements);
		nElements = bModel.getB10s().size();
		assertEquals(2, nElements);

		// Assuming the user decides to create mapping after creating A10
		// element
		// and there is existing B10 element which is not mapped
		bModelController.createB10(bModel, "name2");
		RedefinedAModelLanguageAction.createNewA10(perspective, scene, "A_Model", false, aModel, "name2");

		nElements = aModel.getA10s().size();
		assertEquals(3, nElements);
		nElements = bModel.getB10s().size();
		assertEquals(3, nElements);

	}

	/**
	 * C11: primary multiplicity (0..1) - other multiplicity (0..*)
	 */
	@Test
	public void testCanCreateOrUseNonMappedManyElements() {

		// Assuming the user decides not to create mapping after creating A11
		// element
		QueryAction.INSTANCE.setNumberOfMapping(0);
		RedefinedAModelLanguageAction.createNewA11(perspective, scene, "A_Model", false, aModel, "name");
		int nElements = aModel.getA11s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB11s().size();
		assertEquals(0, nElements);

		// Assuming the user decides to create 5 mappings after creating A11
		// element
		// and there is no existing B11 element
		QueryAction.INSTANCE.setNumberOfMapping(5);
		RedefinedAModelLanguageAction.createNewA11(perspective, scene, "A_Model", false, aModel, "name");
		nElements = aModel.getA11s().size();
		assertEquals(2, nElements);
		nElements = bModel.getB11s().size();
		assertEquals(5, nElements);

		// Assuming the user decides to create mappings after creating A11
		// element
		// and there is existing B11 element which is mapped
		QueryAction.INSTANCE.setNumberOfMapping(3);
		RedefinedAModelLanguageAction.createNewA11(perspective, scene, "A_Model", false, aModel, "name");

		nElements = aModel.getA11s().size();
		assertEquals(3, nElements);
		nElements = bModel.getB11s().size();
		assertEquals(8, nElements);

		// Assuming the user decides to create mapping after creating A11
		// element
		// and there is a corresponding B11 element which is not mapped
		bModelController.createB11(bModel, "name2");
		bModelController.createB11(bModel, "name2");
		QueryAction.INSTANCE.setNumberOfMapping(7);
		RedefinedAModelLanguageAction.createNewA11(perspective, scene, "A_Model", false, aModel, "name2");

		nElements = aModel.getA11s().size();
		assertEquals(4, nElements);
		nElements = bModel.getB11s().size();
		assertEquals(15, nElements);
	}

	/**
	 * C12: primary multiplicity (0..1) - other multiplicity (1..*)
	 */
	@Test
	public void testCreateOrUseNonMappedAtLeastOneElement() {

		QueryAction.INSTANCE.setNumberOfMapping(2);
		RedefinedAModelLanguageAction.createNewA12(perspective, scene, "A_Model", false, aModel, "name");
		int nElements = aModel.getA12s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB12s().size();
		assertEquals(2, nElements);

		// Assuming the user decides to create 5 mappings after creating A12
		// element
		// and there are existing B12 elements which are mapped
		QueryAction.INSTANCE.setNumberOfMapping(5);
		RedefinedAModelLanguageAction.createNewA12(perspective, scene, "A_Model", false, aModel, "name");
		nElements = aModel.getA12s().size();
		assertEquals(2, nElements);
		nElements = bModel.getB12s().size();
		assertEquals(7, nElements);

		// Assuming the user decides to create mappings after creating A12
		// element
		// and there is existing B12 element which is not mapped
		bModelController.createB12(bModel, "name2");
		QueryAction.INSTANCE.setNumberOfMapping(3);
		RedefinedAModelLanguageAction.createNewA12(perspective, scene, "A_Model", false, aModel, "name2");
		nElements = aModel.getA12s().size();
		assertEquals(3, nElements);
		nElements = bModel.getB12s().size();
		assertEquals(10, nElements);

	}

	// Delete tests

	/**
	 * primary multiplicity (0..1) - other multiplicity (0..*)
	 */
	@Test
	public void testJustDelete() {

		// Assuming the user decides to create mappings after creating A1
		// element
		QueryAction.INSTANCE.setNumberOfMapping(5);
		RedefinedAModelLanguageAction.createNewA11(perspective, scene, "A_Model", false, aModel, "name");
		int nElements = aModel.getA11s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB11s().size();
		assertEquals(5, nElements);

		RedefinedAModelLanguageAction.deleteA11(perspective, scene, "A_Model", aModel.getA11s().get(0));
		nElements = aModel.getA11s().size();
		assertEquals(0, nElements);
		nElements = bModel.getB11s().size();
		assertEquals(5, nElements);

	}

	/**
	 * primary multiplicity (1) - other multiplicity (1..*)
	 */
	@Test
	public void testDeleteOthers() {
		// Assuming the user decides to create one mapping after creating A4
		// element
		QueryAction.INSTANCE.setNumberOfMapping(6);
		RedefinedAModelLanguageAction.createNewA4(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA4s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB4s().size();
		assertEquals(6, nElements);

		RedefinedAModelLanguageAction.deleteA4(perspective, scene, "A_Model", aModel.getA4s().get(0));
		nElements = aModel.getA4s().size();
		assertEquals(0, nElements);
		nElements = bModel.getB4s().size();
		assertEquals(0, nElements);

	}
	
	/**
	 * primary multiplicity (1) - other multiplicity (1..*)
	 */
	@Test
	public void testDeleteOthersComplexAction() {
		aModelController.setComplexAction(true);
		QueryAction.INSTANCE.setNumberOfMapping(6);
		// this action can create A4 as a secondary effect
		RedefinedAModelLanguageAction.createNewA1(perspective, scene, "A_Model", false, aModel, "name");
		
		int nElements = aModel.getA1s().size();
		assertEquals(1, nElements);
		
		nElements = aModel.getA4s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB4s().size();
		assertEquals(6, nElements);

		// removing a1 removes a4
		RedefinedAModelLanguageAction.deleteA1(perspective, scene, "A_Model", aModel.getA1s().get(0));
		nElements = aModel.getA1s().size();
		assertEquals(0, nElements);
		nElements = aModel.getA4s().size();
		assertEquals(0, nElements);
		nElements = bModel.getB4s().size();
		assertEquals(0, nElements);

	}

	/**
	 * primary multiplicity (1..*) - other multiplicity (1)
	 */
	@Test
	public void testDeleteSingleMapped1() {

		QueryAction.INSTANCE.setCreateMapping(true);
		RedefinedBModelLanguageAction.createNewB4(perspective, scene, "B_Model", false, bModel, "name");

		int nElements = bModel.getB4s().size();
		assertEquals(1, nElements);
		nElements = aModel.getA4s().size();
		assertEquals(1, nElements);

		RedefinedBModelLanguageAction.deleteB4(perspective, scene, "B_Model", bModel.getB4s().get(0));
		nElements = bModel.getB4s().size();
		assertEquals(0, nElements);
		nElements = aModel.getA4s().size();
		assertEquals(0, nElements);

	}

	/**
	 * primary multiplicity (1..*) - other multiplicity (0..1)
	 */
	@Test
	public void testDeleteSingleMapped2() {

		// Assuming the user decides to create mapping after creating B12
		// element
		// and there is no existing A12 element
		QueryAction.INSTANCE.setCreateMapping(true);
		RedefinedBModelLanguageAction.createNewB12(perspective, scene, "B_Model", false, bModel, "name");

		int nElements = bModel.getB12s().size();
		assertEquals(1, nElements);
		nElements = aModel.getA12s().size();
		assertEquals(1, nElements);

		// Assuming the user decides to create mapping after creating B12
		// element
		// and there is corresponding A12 element
		QueryAction.INSTANCE.setCreateMapping(true);
		RedefinedBModelLanguageAction.createNewB12(perspective, scene, "B_Model", false, bModel, "name");

		nElements = bModel.getB12s().size();
		assertEquals(2, nElements);
		nElements = aModel.getA12s().size();
		assertEquals(1, nElements);

		RedefinedBModelLanguageAction.deleteB12(perspective, scene, "B_Model", bModel.getB12s().get(0));
		nElements = bModel.getB12s().size();
		assertEquals(1, nElements);
		nElements = aModel.getA12s().size();
		assertEquals(1, nElements);

	}

	// Updates tests

	/**
	 * primary multiplicity (1..*) - other multiplicity (0..1)
	 */
	@Test
	public void testUpdate() {
		QueryAction.INSTANCE.setCreateMapping(true);
		RedefinedAModelLanguageAction.createNewA1(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA1s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB1s().size();
		assertEquals(1, nElements);

		PerspectiveControllerFactory.INSTANCE.getBasePerspectiveController().updateElement(perspective, scene,
				"A_Model", aModel.getA1s().get(0), AmodelPackage.eINSTANCE.getNamedElement_Name(), "name2");
		assertEquals("name2", bModel.getB1s().get(0).getName());

	}

	/**
	 * primary multiplicity (1) - other multiplicity (1..*)
	 */
	@Test
	public void testUpdateMultiple() {
		QueryAction.INSTANCE.setNumberOfMapping(6);
		RedefinedAModelLanguageAction.createNewA4(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA4s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB4s().size();
		assertEquals(6, nElements);

		PerspectiveControllerFactory.INSTANCE.getBasePerspectiveController().updateElement(perspective, scene,
				"A_Model", aModel.getA4s().get(0), AmodelPackage.eINSTANCE.getNamedElement_Name(), "name2");
		assertEquals("name2", bModel.getB4s().get(0).getName());
		assertEquals("name2", bModel.getB4s().get(1).getName());
		assertEquals("name2", bModel.getB4s().get(2).getName());
		assertEquals("name2", bModel.getB4s().get(3).getName());
		assertEquals("name2", bModel.getB4s().get(4).getName());
		assertEquals("name2", bModel.getB4s().get(5).getName());

	}

	/**
	 * primary multiplicity (0..1) - other multiplicity (0..*)
	 */
	@Test
	public void testUpdateMultiple2() {
		// Assuming the user decides to create 7 mappings after creating A11
		// element
		QueryAction.INSTANCE.setNumberOfMapping(7);
		RedefinedAModelLanguageAction.createNewA11(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA11s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB11s().size();
		assertEquals(7, nElements);

		PerspectiveControllerFactory.INSTANCE.getBasePerspectiveController().updateElement(perspective, scene,
				"A_Model", aModel.getA11s().get(0), AmodelPackage.eINSTANCE.getNamedElement_Name(), "name2");
		assertEquals("name2", bModel.getB11s().get(0).getName());
		assertEquals("name2", bModel.getB11s().get(1).getName());
		assertEquals("name2", bModel.getB11s().get(2).getName());
		assertEquals("name2", bModel.getB11s().get(3).getName());
		assertEquals("name2", bModel.getB11s().get(4).getName());
		assertEquals("name2", bModel.getB11s().get(5).getName());
		assertEquals("name2", bModel.getB11s().get(6).getName());

	}

	/**
	 * primary multiplicity (0..1) - other multiplicity (0..*)
	 */
	@Test
	public void testUpdateMultipleWithSomeNonMapped() {
		// Assuming the user decides to create 7 mappings after creating A11
		// element
		QueryAction.INSTANCE.setNumberOfMapping(7);
		RedefinedAModelLanguageAction.createNewA11(perspective, scene, "A_Model", false, aModel, "name");

		int nElements = aModel.getA11s().size();
		assertEquals(1, nElements);
		nElements = bModel.getB11s().size();
		assertEquals(7, nElements);

		QueryAction.INSTANCE.setCreateMapping(false);
		// create element B11 (3X)
		RedefinedBModelLanguageAction.createNewB11(perspective, scene, "B_Model", false, bModel, "name2");
		RedefinedBModelLanguageAction.createNewB11(perspective, scene, "B_Model", false,  bModel, "name2");
		RedefinedBModelLanguageAction.createNewB11(perspective, scene, "B_Model", false, bModel, "name2");
		nElements = bModel.getB11s().size();
		assertEquals(10, nElements);

		PerspectiveControllerFactory.INSTANCE.getBasePerspectiveController().updateElement(perspective, scene,
				"A_Model", aModel.getA11s().get(0), AmodelPackage.eINSTANCE.getNamedElement_Name(), "name3");
		int updatedBs = 0;
		for (B11 b : bModel.getB11s()) {
			if (b.getName().equals("name3")) {
				updatedBs++;
			}
		}
		assertEquals(7, updatedBs);

	}

	private static void setUpModels() {
		perspective = MainPerspectiveTest.initializePerspective();
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
