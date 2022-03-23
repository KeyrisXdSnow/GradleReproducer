import annotation.API

@API
enum TestEnum implements Serializable {
	@API
	ITEM1(1),

	@API
	ITEM2(2),
	@API
	ITEM3(3);

	private Integer value

	TestEnum(Integer value) {
		this.value = value
	}

	Integer getValue() {
		return this.value
	}

}
