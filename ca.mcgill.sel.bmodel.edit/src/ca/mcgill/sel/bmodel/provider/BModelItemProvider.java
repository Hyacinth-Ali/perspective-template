/**
 */
package ca.mcgill.sel.bmodel.provider;


import ca.mcgill.sel.bmodel.BModel;
import ca.mcgill.sel.bmodel.BmodelFactory;
import ca.mcgill.sel.bmodel.BmodelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link ca.mcgill.sel.bmodel.BModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BModelItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BModelItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(BmodelPackage.Literals.BMODEL__B1S);
			childrenFeatures.add(BmodelPackage.Literals.BMODEL__B2S);
			childrenFeatures.add(BmodelPackage.Literals.BMODEL__B5S);
			childrenFeatures.add(BmodelPackage.Literals.BMODEL__B3S);
			childrenFeatures.add(BmodelPackage.Literals.BMODEL__B12S);
			childrenFeatures.add(BmodelPackage.Literals.BMODEL__B6S);
			childrenFeatures.add(BmodelPackage.Literals.BMODEL__B4S);
			childrenFeatures.add(BmodelPackage.Literals.BMODEL__B7S);
			childrenFeatures.add(BmodelPackage.Literals.BMODEL__B11S);
			childrenFeatures.add(BmodelPackage.Literals.BMODEL__B10S);
			childrenFeatures.add(BmodelPackage.Literals.BMODEL__B9S);
			childrenFeatures.add(BmodelPackage.Literals.BMODEL__B8S);
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
	 * This returns BModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BModel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((BModel)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_BModel_type") :
			getString("_UI_BModel_type") + " " + label;
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

		switch (notification.getFeatureID(BModel.class)) {
			case BmodelPackage.BMODEL__B1S:
			case BmodelPackage.BMODEL__B2S:
			case BmodelPackage.BMODEL__B5S:
			case BmodelPackage.BMODEL__B3S:
			case BmodelPackage.BMODEL__B12S:
			case BmodelPackage.BMODEL__B6S:
			case BmodelPackage.BMODEL__B4S:
			case BmodelPackage.BMODEL__B7S:
			case BmodelPackage.BMODEL__B11S:
			case BmodelPackage.BMODEL__B10S:
			case BmodelPackage.BMODEL__B9S:
			case BmodelPackage.BMODEL__B8S:
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
				(BmodelPackage.Literals.BMODEL__B1S,
				 BmodelFactory.eINSTANCE.createB1()));

		newChildDescriptors.add
			(createChildParameter
				(BmodelPackage.Literals.BMODEL__B2S,
				 BmodelFactory.eINSTANCE.createB2()));

		newChildDescriptors.add
			(createChildParameter
				(BmodelPackage.Literals.BMODEL__B5S,
				 BmodelFactory.eINSTANCE.createB5()));

		newChildDescriptors.add
			(createChildParameter
				(BmodelPackage.Literals.BMODEL__B3S,
				 BmodelFactory.eINSTANCE.createB3()));

		newChildDescriptors.add
			(createChildParameter
				(BmodelPackage.Literals.BMODEL__B12S,
				 BmodelFactory.eINSTANCE.createB12()));

		newChildDescriptors.add
			(createChildParameter
				(BmodelPackage.Literals.BMODEL__B6S,
				 BmodelFactory.eINSTANCE.createB6()));

		newChildDescriptors.add
			(createChildParameter
				(BmodelPackage.Literals.BMODEL__B4S,
				 BmodelFactory.eINSTANCE.createB4()));

		newChildDescriptors.add
			(createChildParameter
				(BmodelPackage.Literals.BMODEL__B7S,
				 BmodelFactory.eINSTANCE.createB7()));

		newChildDescriptors.add
			(createChildParameter
				(BmodelPackage.Literals.BMODEL__B11S,
				 BmodelFactory.eINSTANCE.createB11()));

		newChildDescriptors.add
			(createChildParameter
				(BmodelPackage.Literals.BMODEL__B10S,
				 BmodelFactory.eINSTANCE.createB10()));

		newChildDescriptors.add
			(createChildParameter
				(BmodelPackage.Literals.BMODEL__B9S,
				 BmodelFactory.eINSTANCE.createB9()));

		newChildDescriptors.add
			(createChildParameter
				(BmodelPackage.Literals.BMODEL__B8S,
				 BmodelFactory.eINSTANCE.createB8()));
	}

}
