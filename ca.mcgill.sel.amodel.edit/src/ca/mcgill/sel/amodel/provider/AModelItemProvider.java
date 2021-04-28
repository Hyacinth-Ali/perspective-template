/**
 */
package ca.mcgill.sel.amodel.provider;


import ca.mcgill.sel.amodel.AModel;
import ca.mcgill.sel.amodel.AmodelFactory;
import ca.mcgill.sel.amodel.AmodelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link ca.mcgill.sel.amodel.AModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AModelItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AModelItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(AmodelPackage.Literals.AMODEL__A1S);
			childrenFeatures.add(AmodelPackage.Literals.AMODEL__A2S);
			childrenFeatures.add(AmodelPackage.Literals.AMODEL__A5S);
			childrenFeatures.add(AmodelPackage.Literals.AMODEL__A3S);
			childrenFeatures.add(AmodelPackage.Literals.AMODEL__A12S);
			childrenFeatures.add(AmodelPackage.Literals.AMODEL__A6S);
			childrenFeatures.add(AmodelPackage.Literals.AMODEL__A4S);
			childrenFeatures.add(AmodelPackage.Literals.AMODEL__A7S);
			childrenFeatures.add(AmodelPackage.Literals.AMODEL__A11S);
			childrenFeatures.add(AmodelPackage.Literals.AMODEL__A10S);
			childrenFeatures.add(AmodelPackage.Literals.AMODEL__A9S);
			childrenFeatures.add(AmodelPackage.Literals.AMODEL__A8S);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns AModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AModel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((AModel)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_AModel_type") :
			getString("_UI_AModel_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(AModel.class)) {
			case AmodelPackage.AMODEL__A1S:
			case AmodelPackage.AMODEL__A2S:
			case AmodelPackage.AMODEL__A5S:
			case AmodelPackage.AMODEL__A3S:
			case AmodelPackage.AMODEL__A12S:
			case AmodelPackage.AMODEL__A6S:
			case AmodelPackage.AMODEL__A4S:
			case AmodelPackage.AMODEL__A7S:
			case AmodelPackage.AMODEL__A11S:
			case AmodelPackage.AMODEL__A10S:
			case AmodelPackage.AMODEL__A9S:
			case AmodelPackage.AMODEL__A8S:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(AmodelPackage.Literals.AMODEL__A1S,
				 AmodelFactory.eINSTANCE.createA1()));

		newChildDescriptors.add
			(createChildParameter
				(AmodelPackage.Literals.AMODEL__A2S,
				 AmodelFactory.eINSTANCE.createA2()));

		newChildDescriptors.add
			(createChildParameter
				(AmodelPackage.Literals.AMODEL__A5S,
				 AmodelFactory.eINSTANCE.createA5()));

		newChildDescriptors.add
			(createChildParameter
				(AmodelPackage.Literals.AMODEL__A3S,
				 AmodelFactory.eINSTANCE.createA3()));

		newChildDescriptors.add
			(createChildParameter
				(AmodelPackage.Literals.AMODEL__A12S,
				 AmodelFactory.eINSTANCE.createA12()));

		newChildDescriptors.add
			(createChildParameter
				(AmodelPackage.Literals.AMODEL__A6S,
				 AmodelFactory.eINSTANCE.createA6()));

		newChildDescriptors.add
			(createChildParameter
				(AmodelPackage.Literals.AMODEL__A4S,
				 AmodelFactory.eINSTANCE.createA4()));

		newChildDescriptors.add
			(createChildParameter
				(AmodelPackage.Literals.AMODEL__A7S,
				 AmodelFactory.eINSTANCE.createA7()));

		newChildDescriptors.add
			(createChildParameter
				(AmodelPackage.Literals.AMODEL__A11S,
				 AmodelFactory.eINSTANCE.createA11()));

		newChildDescriptors.add
			(createChildParameter
				(AmodelPackage.Literals.AMODEL__A10S,
				 AmodelFactory.eINSTANCE.createA10()));

		newChildDescriptors.add
			(createChildParameter
				(AmodelPackage.Literals.AMODEL__A9S,
				 AmodelFactory.eINSTANCE.createA9()));

		newChildDescriptors.add
			(createChildParameter
				(AmodelPackage.Literals.AMODEL__A8S,
				 AmodelFactory.eINSTANCE.createA8()));
	}

}
