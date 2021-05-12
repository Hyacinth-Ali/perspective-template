package ca.mcgill.sel.cmodel.controller;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import ca.mcgill.sel.cmodel.C1;
import ca.mcgill.sel.cmodel.C2;
import ca.mcgill.sel.cmodel.C3;
import ca.mcgill.sel.cmodel.C4;
import ca.mcgill.sel.cmodel.CModel;
import ca.mcgill.sel.cmodel.CmodelFactory;
import ca.mcgill.sel.cmodel.CmodelPackage;
import ca.mcgill.sel.commons.emf.util.EMFEditUtil;
import ca.mcgill.sel.core.controller.CoreBaseController;

/**
 * The controller for {@link aModelController}
 * 
 * @author hyacinthali
 *
 */
public class CModelController extends CoreBaseController {

	private static CModelController cModelController;
	private static CModel cModel;
	private boolean complexAction;
	private C1 c1;

	private CModelController() {

	}

	public C1 getC1() {
		return c1;
	}

	public void setC1(C1 c1) {
		this.c1 = c1;
	}

	public CModel getCModel() {

		if (cModel == null) {
			// create new model
			cModel = CmodelFactory.eINSTANCE.createCModel();
			cModel.setName("name");
		}
		return cModel;
	}

	// create language actions

	public C1 createC1(CModel owner, String name) {

		C1 newC1 = CmodelFactory.eINSTANCE.createC1();
		newC1.setName(name);

		EditingDomain editingDomain = EMFEditUtil.getEditingDomain(owner);

		// Create commands.
		Command addA1Command = AddCommand.create(editingDomain, owner, CmodelPackage.Literals.CMODEL__C1S, newC1);

		// Create compound command.
		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.append(addA1Command);

		doExecute(editingDomain, compoundCommand);

		return newC1;

	}

	public C2 createC2(CModel owner, String name) {

		C2 newC2 = CmodelFactory.eINSTANCE.createC2();
		newC2.setName(name);

		EditingDomain editingDomain = EMFEditUtil.getEditingDomain(owner);

		// Create commands.
		Command addA2Command = AddCommand.create(editingDomain, owner, CmodelPackage.Literals.CMODEL__C2S, newC2);

		// Create compound command.
		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.append(addA2Command);

		doExecute(editingDomain, compoundCommand);

		// check if the C1 with the same name exist
		C1 c1 = c1Exist(owner, name);
		if (c1 == null) {
			// create new message type
			c1 = createC1(owner, name);
			setC1(c1);
		}

		return newC2;

	}

	public C3 createC3(CModel owner, String name) {

		C3 newC3 = CmodelFactory.eINSTANCE.createC3();
		newC3.setName(name);

		EditingDomain editingDomain = EMFEditUtil.getEditingDomain(owner);

		// Create commands.
		Command addA3Command = AddCommand.create(editingDomain, owner, CmodelPackage.Literals.CMODEL__C3S, newC3);

		// Create compound command.
		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.append(addA3Command);

		doExecute(editingDomain, compoundCommand);

		return newC3;

	}

	public C4 createC4(CModel owner, String name) {

		C4 newC4 = CmodelFactory.eINSTANCE.createC4();
		newC4.setName(name);

		EditingDomain editingDomain = EMFEditUtil.getEditingDomain(owner);

		// Create commands.
		Command addA4Command = AddCommand.create(editingDomain, owner, CmodelPackage.Literals.CMODEL__C4S, newC4);

		// Create compound command.
		CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.append(addA4Command);

		doExecute(editingDomain, compoundCommand);

		return newC4;

	}

	public void removeC1(C1 c) {
		CModel cModel = (CModel) c.eContainer();
		EditingDomain editingDomain = EMFEditUtil.getEditingDomain(cModel);

		CompoundCommand compoundCommand = new CompoundCommand();

		// Create command for removing actor.
		Command removeaCommand = RemoveCommand.create(editingDomain, c);
		compoundCommand.append(removeaCommand);

		doExecute(editingDomain, compoundCommand);
	}

	public void removeC2(C2 c) {
		CModel cModel = (CModel) c.eContainer();
		EditingDomain editingDomain = EMFEditUtil.getEditingDomain(cModel);

		CompoundCommand compoundCommand = new CompoundCommand();

		// Create command for removing actor.
		Command removeaCommand = RemoveCommand.create(editingDomain, c);
		compoundCommand.append(removeaCommand);

		doExecute(editingDomain, compoundCommand);

	}

	public void removeC3(C3 c) {
		CModel cModel = (CModel) c.eContainer();
		EditingDomain editingDomain = EMFEditUtil.getEditingDomain(cModel);

		CompoundCommand compoundCommand = new CompoundCommand();

		// Create command for removing actor.
		Command removeaCommand = RemoveCommand.create(editingDomain, c);
		compoundCommand.append(removeaCommand);

		doExecute(editingDomain, compoundCommand);
	}

	public void removeC4(C4 a) {
		CModel cModel = (CModel) a.eContainer();
		EditingDomain editingDomain = EMFEditUtil.getEditingDomain(cModel);

		CompoundCommand compoundCommand = new CompoundCommand();

		// Create command for removing actor.
		Command removeaCommand = RemoveCommand.create(editingDomain, a);
		compoundCommand.append(removeaCommand);

		doExecute(editingDomain, compoundCommand);
	}

	public static CModelController getInstance() {
		if (cModelController == null) {
			cModelController = new CModelController();
		}
		return cModelController;
	}

	private C1 c1Exist(CModel cModel, String name) {
		C1 c1 = null;
		for (C1 t : cModel.getC1s()) {
			if (t.getName().equals(name)) {
				c1 = t;
			}
		}
		return c1;
	}

}
