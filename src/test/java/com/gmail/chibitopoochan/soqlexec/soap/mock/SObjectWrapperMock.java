package com.gmail.chibitopoochan.soqlexec.soap.mock;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import com.gmail.chibitopoochan.soqlexec.soap.partner.wrapper.PartnerQNameWrapper;
import com.gmail.chibitopoochan.soqlexec.soap.partner.wrapper.PartnerSObjectWrapper;
import com.gmail.chibitopoochan.soqlexec.soap.partner.wrapper.PartnerXmlObjectWrapper;
import com.gmail.chibitopoochan.soqlexec.soap.wrapper.ObjectWrapper;

public class SObjectWrapperMock extends PartnerSObjectWrapper {
	private Map<String, ObjectWrapper> childMap = new HashMap<>();
	private PartnerQNameWrapper name;
	private Object value;

	public void setValue(Object value) {
		this.value = value;
	}

	/* (非 Javadoc)
	 * @see com.gmail.chibitopoochan.soqlexec.soap.wrapper.SObjectWrapper#getValue()
	 */
	@Override
	public Optional<Object> getValue() {
		return Optional.ofNullable(value);
	}

	/* (非 Javadoc)
	 * @see com.gmail.chibitopoochan.soqlexec.soap.wrapper.SObjectWrapper#getField(java.lang.String)
	 */
	@Override
	public Optional<Object> getField(String name) {
		if(childMap.containsKey(name)) {
			return childMap.get(name).getValue();
		} else {
			return Optional.empty();
		}
	}

	public void addChild(PartnerXmlObjectWrapper value) {
		childMap.put(value.getName().getLocalPart(), value);
	}

	/* (非 Javadoc)
	 * @see com.gmail.chibitopoochan.soqlexec.soap.wrapper.SObjectWrapper#getChildren()
	 */
	@Override
	public Iterator<ObjectWrapper> getChildren() {
		return childMap.values().iterator();
	}

	/* (非 Javadoc)
	 * @see com.gmail.chibitopoochan.soqlexec.soap.wrapper.SObjectWrapper#getChild(java.lang.String)
	 */
	@Override
	public Optional<ObjectWrapper> getChild(String name) {
		return Optional.ofNullable(childMap.get(name));
	}

	public void setName(PartnerQNameWrapper name){
		this.name = name;
	}

	/* (非 Javadoc)
	 * @see com.gmail.chibitopoochan.soqlexec.soap.wrapper.SObjectWrapper#getName()
	 */
	@Override
	public PartnerQNameWrapper getName() {
		return name;
	}

}
