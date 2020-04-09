/**
 * 
 */
package com.java.practice.interfaz;
import java.util.List;

/**
 * @author esliv
 * The ISaveable interfaces
 */
public interface ICharacter {
	String defaultWeapon = "Sword";
	double defaultHealth = 100;
	
	void readFrom(List<String> list);
	List<String> writeTo();
}
