package com.book.common.vo;

public class JsonResult {
	private static final int SUCCESS = 1;
	private static final int ERROR = 0;

	// 封装的具体数据
	private Object data;

	private byte statue=SUCCESS;

	private String message;

	// 创建重载的构造方法
	public JsonResult() {
		message = "action ok";
	}

	public JsonResult(String message) {
		this.message = message;
	}

	public JsonResult(Object data) {
		this.data = data;
	}

	public JsonResult(Throwable e) {
		statue = ERROR;
		message = e.getMessage();
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public byte getStatue() {
		return statue;
	}

	public void setStatue(byte statue) {
		this.statue = statue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JsonResult [data=" + data + ", statue=" + statue + ", message=" + message + "]";
	}

}
