/**
 */
package language1.provider;


import java.util.Collection;
import java.util.List;

import language1.Language1;
import language1.Language1Factory;
import language1.Language1Package;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link language1.Language1} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Language1ItemProvider extends NameElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language1ItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(Language1Package.Literals.LANGUAGE1__LEMA1S);
			childrenFeatures.add(Language1Package.Literals.LANGUAGE1__LEMB1S);
			childrenFeatures.add(Language1Package.Literals.LANGUAGE1__LEME1S);
			childrenFeatures.add(Language1Package.Literals.LANGUAGE1__LEMC1S);
			childrenFeatures.add(Language1Package.Literals.LANGUAGE1__LEML1S);
			childrenFeatures.add(Language1Package.Literals.LANGUAGE1__LEMF1S);
			childrenFeatures.add(Language1Package.Literals.LANGUAGE1__LEMD1S);
			childrenFeatures.add(Language1Package.Literals.LANGUAGE1__LEMG1S);
			childrenFeatures.add(Language1Package.Literals.LANGUAGE1__LEMK1S);
			childrenFeatures.add(Language1Package.Literals.LANGUAGE1__LEMJ1S);
			childrenFeatures.add(Language1Package.Literals.LANGUAGE1__LEMI1S);
			childrenFeatures.add(Language1Package.Literals.LANGUAGE1__LEMH1S);
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
	 * This returns Language1.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Language1"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Language1)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Language1_type") :
			getString("_UI_Language1_type") + " " + label;
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

		switch (notification.getFeatureID(Language1.class)) {
			case Language1Package.LANGUAGE1__LEMA1S:
			case Language1Package.LANGUAGE1__LEMB1S:
			case Language1Package.LANGUAGE1__LEME1S:
			case Language1Package.LANGUAGE1__LEMC1S:
			case Language1Package.LANGUAGE1__LEML1S:
			case Language1Package.LANGUAGE1__LEMF1S:
			case Language1Package.LANGUAGE1__LEMD1S:
			case Language1Package.LANGUAGE1__LEMG1S:
			case Language1Package.LANGUAGE1__LEMK1S:
			case Language1Package.LANGUAGE1__LEMJ1S:
			case Language1Package.LANGUAGE1__LEMI1S:
			case Language1Package.LANGUAGE1__LEMH1S:
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
				(Language1Package.Literals.LANGUAGE1__LEMA1S,
				 Language1Factory.eINSTANCE.createLEMA1()));

		newChildDescriptors.add
			(createChildParameter
				(Language1Package.Literals.LANGUAGE1__LEMB1S,
				 Language1Factory.eINSTANCE.createLEMB1()));

		newChildDescriptors.add
			(createChildParameter
				(Language1Package.Literals.LANGUAGE1__LEME1S,
				 Language1Factory.eINSTANCE.createLEME1()));

		newChildDescriptors.add
			(createChildParameter
				(Language1Package.Literals.LANGUAGE1__LEMC1S,
				 Language1Factory.eINSTANCE.createLEMC1()));

		newChildDescriptors.add
			(createChildParameter
				(Language1Package.Literals.LANGUAGE1__LEML1S,
				 Language1Factory.eINSTANCE.createLEML1()));

		newChildDescriptors.add
			(createChildParameter
				(Language1Package.Literals.LANGUAGE1__LEMF1S,
				 Language1Factory.eINSTANCE.createLEMF1()));

		newChildDescriptors.add
			(createChildParameter
				(Language1Package.Literals.LANGUAGE1__LEMD1S,
				 Language1Factory.eINSTANCE.createLEMD1()));

		newChildDescriptors.add
			(createChildParameter
				(Language1Package.Literals.LANGUAGE1__LEMG1S,
				 Language1Factory.eINSTANCE.createLEMG1()));

		newChildDescriptors.add
			(createChildParameter
				(Language1Package.Literals.LANGUAGE1__LEMK1S,
				 Language1Factory.eINSTANCE.createLEMK1()));

		newChildDescriptors.add
			(createChildParameter
				(Language1Package.Literals.LANGUAGE1__LEMJ1S,
				 Language1Factory.eINSTANCE.createLEMJ1()));

		newChildDescriptors.add
			(createChildParameter
				(Language1Package.Literals.LANGUAGE1__LEMI1S,
				 Language1Factory.eINSTANCE.createLEMI1()));

		newChildDescriptors.add
			(createChildParameter
				(Language1Package.Literals.LANGUAGE1__LEMH1S,
				 Language1Factory.eINSTANCE.createLEMH1()));
	}

}
