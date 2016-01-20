package com.it1224.demos.psretrofit.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.it1224.demos.psretrofit.annotation.ParamName;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * 自定义的Gson
 */
public class GsonUtils {

	public static Gson newInstance() {
		GsonBuilder builder = new GsonBuilder();
		// 自定义的反序列化适配?
//		builder.registerTypeAdapter(Gender.class, new Gender.GenderAdapter());

		builder.setFieldNamingStrategy(new AnnotateNaming());
		if (false) {
			builder.setPrettyPrinting();
		}

		return builder.create();
	}

	private static class AnnotateNaming implements FieldNamingStrategy {

		@Override
		public String translateName(Field field) {
			ParamName a = field.getAnnotation(ParamName.class);
			return a != null ? a.value() : FieldNamingPolicy.IDENTITY
					.translateName(field);
		}
	}

	public static <T> T fromJson(String res, Class<T> clz) {
		Gson gson = new Gson();
		T t = gson.fromJson(res, clz);
		return t;
	}

	public <T> ArrayList<T> fromJsonList(String json, Class<T> cls) {
		ArrayList<T> mList = new ArrayList<T>();
		Gson mGson=new Gson();
		JsonArray array = new JsonParser().parse(json).getAsJsonArray();
		for(final JsonElement elem : array){
			mList.add(mGson.fromJson(elem, cls));
		}
		return mList;
	}
}
