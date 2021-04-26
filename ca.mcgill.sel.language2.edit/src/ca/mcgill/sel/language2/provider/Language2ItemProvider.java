/**
 */
package ca.mcgill.sel.language2.provider;


import ca.mcgill.sel.language2.Language2;
import ca.mcgill.sel.language2.Language2Factory;
import ca.mcgill.sel.language2.Language2Package;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link ca.mcgill.sel.language2.Language2} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Language2ItemProvider extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language2ItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(Language2Package.Literals.LANGUAGE2__LEMA2S);
			childrenFeatures.add(Language2Package.Literals.LANGUAGE2__LEMB2S);
			childrenFeatures.add(Language2Package.Literals.LANGUAGE2__LEME2S);
			childrenFeatures.add(Language2Package.Literals.LANGUAGE2__LEMC2S);
			childrenFeatures.add(Language2Package.Literals.LANGUAGE2__LEML2S);
			childrenFeatures.add(Language2Package.Literals.LANGUAGE2__LEMF2S);
			childrenFeatures.add(Language2Package.Literals.LANGUAGE2__LEMD2S);
			childrenFeatures.add(Language2Package.Literals.LANGUAGE2__LEMG2S);
			childrenFeatures.add(Language2Package.Literals.LANGUAGE2__LEMK2S);
			childrenFeatures.add(Language2Package.Literals.LANGUAGE2__LEMJ2S);
			childrenFeatures.add(Language2Package.Literals.LANGUAGE2__LEMI2S);
			childrenFeatures.add(Language2Package.Literals.LANGUAGE2__LEMH2S);
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
	 * This returns Language2.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Language2"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Language2)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Language2_type") :
			getString("_UI_Language2_type") + " " + label;
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

		switch (notification.getFeatureID(Language2.class)) {
			case Language2Package.LANGUAGE2__LEMA2S:
			case Language2Package.LANGUAGE2__LEMB2S:
			case Language2Package.LANGUAGE2__LEME2S:
			case Language2Package.LANGUAGE2__LEMC2S:
			case Language2Package.LANGUAGE2__LEML2S:
			case Language2Package.LANGUAGE2__LEMF2S:
			case Language2Package.LANGUAGE2__LEMD2S:
			case Language2Package.LANGUAGE2__LEMG2S:
			case Language2Package.LANGUAGE2__LEMK2S:
			case Language2Package.LANGUAGE2__LEMJ2S:
			case Language2Package.LANGUAGE2__LEMI2S:
			case Language2Package.LANGUAGE2__LEMH2S:
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
				(Language2Package.Literals.LANGUAGE2__LEMA2S,
				 Language2Factory.eINSTANCE.createLEMA2()));

		newChildDescriptors.add
			(createChildParameter
				(Language2Package.Literals.LANGUAGE2__LEMB2S,
				 Language2Factory.eINSTANCE.createLEMB2()));

		newChildDescriptors.add
			(createChildParameter
				(Language2Package.Literals.LANGUAGE2__LEME2S,
				 Language2Factory.eINSTANCE.createLEME2()));

		newChildDescriptors.add
			(createChildParameter
				(Language2Package.Literals.LANGUAGE2__LEMC2S,
				 Language2Factory.eINSTANCE.createLEMC2()));

		newChildDescriptors.add
			(createChildParameter
				(Language2Package.Literals.LANGUAGE2__LEML2S,
				 Language2Factory.eINSTANCE.createLEML2()));

		newChildDescriptors.add
			(createChildParameter
				(Language2Package.Literals.LANGUAGE2__LEMF2S,
				 Language2Factory.eINSTANCE.createLEMF2()));

		newChildDescriptors.add
			(createChildParameter
				(Language2Package.Literals.LANGUAGE2__LEMD2S,
				 Language2Factory.eINSTANCE.createLEMD2()));

		newChildDescriptors.add
			(createChildParameter
				(Language2Package.Literals.LANGUAGE2__LEMG2S,
				 Language2Factory.eINSTANCE.createLEMG2()));

		newChildDescriptors.add
			(createChildParameter
				(Language2Package.Literals.LANGUAGE2__LEMK2S,
				 Language2Factory.eINSTANCE.createLEMK2()));

		newChildDescriptors.add
			(createChildParameter
				(Language2Package.Literals.LANGUAGE2__LEMJ2S,
				 Language2Factory.eINSTANCE.createLEMJ2()));

		newChildDescriptors.add
			(createChildParameter
				(Language2Package.Literals.LANGUAGE2__LEMI2S,
				 Language2Factory.eINSTANCE.createLEMI2()));

		newChildDescriptors.add
			(createChildParameter
				(Language2Package.Literals.LANGUAGE2__LEMH2S,
				 Language2Factory.eINSTANCE.createLEMH2()));
	}

}
