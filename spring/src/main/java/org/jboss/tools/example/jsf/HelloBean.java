
package org.jboss.tools.example.jsf;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.jboss.tools.example.springmvc.data.MemberDao;
import org.jboss.tools.example.springmvc.model.Member;


@SuppressWarnings("serial")
@ManagedBean
@RequestScoped
public class HelloBean implements Serializable {

	
//	
	private String name;
	
	@ManagedProperty("#{memberDaoImpl}")
	private MemberDao memberDaoImpl;
	
	

	@PostConstruct
	private void init() {
		System.out.println(memberDaoImpl.findAllOrderedByName().size());
	}

	public void sayHello() {

		Member member = new Member();
		member.setName("战三");
		member.setEmail("123@dd.com");
		member.setPhoneNumber("1234567");
		memberDaoImpl.register(member);

		System.out.println(memberDaoImpl.findAllOrderedByName().size());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MemberDao getMemberDaoImpl() {
		return memberDaoImpl;
	}

	public void setMemberDaoImpl(MemberDao memberDaoImpl) {
		this.memberDaoImpl = memberDaoImpl;
	}

}
