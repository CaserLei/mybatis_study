package day67.one2one.entity;

/**
 * 人
 * @author leifeng
 * 2016年10月3日
 */
public class Person {
	private Integer id;
	private String name;
	private Card card;
	
	public Person(){}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
