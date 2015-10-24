/*******************************************************************************
 * Copyright 2011-2013 Sergey Tarasevich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.example.circle_image;

import com.example.myanimation.myanimation.R;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public final class Constants {

	public static final String[] IMAGES = new String[] {
			// Heavy images
			"drawable://" + R.mipmap.touxiang,
			"http://dl.image.so.com/d?imgurl=http%3A%2F%2Fp2.so.qhimg.com%2Ft014a0ad04518def67c.jpg&purl=http%3A%2F%2Fimage.so.com%2F%3Fsrc%3Ddl.image&key=c41446cf97",
			"http://dl.image.so.com/d?imgurl=http%3A%2F%2Fp1.so.qhimg.com%2Ft01f993b1089c67c631.jpg&purl=http%3A%2F%2Fimage.so.com%2F%3Fsrc%3Ddl.image&key=25fe7c8e9e",
			"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3229727480,642457655&fm=116&gp=0.jpg",
			"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=48252272,1629415252&fm=116&gp=0.jpg",
			"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2162766932,244861494&fm=116&gp=0.jpg",
			"http://dl.image.so.com/d?imgurl=http%3A%2F%2Fp1.so.qhimg.com%2Ft01ca4f7242374b325b.jpg&purl=http%3A%2F%2Fimage.so.com%2F%3Fsrc%3Ddl.image&key=cc29a7236a",
			"http://dl.image.so.com/d?imgurl=http%3A%2F%2Fp4.so.qhimg.com%2Ft0122948ce9812bdab9.jpg&purl=http%3A%2F%2Fimage.so.com%2F%3Fsrc%3Ddl.image&key=32af00bccb",
			"http://dl.image.so.com/d?imgurl=http%3A%2F%2Fp2.so.qhimg.com%2Ft019aff6ce2633caea2.jpg&purl=http%3A%2F%2Fimage.so.com%2F%3Fsrc%3Ddl.image&key=f9a458112e",
			"http://dl.image.so.com/d?imgurl=http%3A%2F%2Fp4.so.qhimg.com%2Ft017151d9e90da1c494.jpg&purl=http%3A%2F%2Fimage.so.com%2F%3Fsrc%3Ddl.image&key=26230d246b",
			"http://dl.image.so.com/d?imgurl=http%3A%2F%2Fp1.so.qhimg.com%2Ft0162592c555401ca91.jpg&purl=http%3A%2F%2Fimage.so.com%2F%3Fsrc%3Ddl.image&key=c85ca088e4",
			"http://dl.image.so.com/d?imgurl=http%3A%2F%2Fp2.so.qhimg.com%2Ft012576bdfc9d4ea482.jpg&purl=http%3A%2F%2Fimage.so.com%2F%3Fsrc%3Ddl.image&key=9766cd63c8",

			// Special cases
			"http://cdn.urbanislandz.com/wp-content/uploads/2011/10/MMSposter-large.jpg", // Very large image
			"http://www.ioncannon.net/wp-content/uploads/2011/06/test9.webp", // WebP image
			"http://4.bp.blogspot.com/-LEvwF87bbyU/Uicaskm-g6I/AAAAAAAAZ2c/V-WZZAvFg5I/s800/Pesto+Guacamole+500w+0268.jpg", // Image with "Mark has been invalidated" problem
			"file:///sdcard/Universal Image Loader @#&=+-_.,!()~'%20.png", // Image from SD card with encoded symbols
			"assets://Living Things @#&=+-_.,!()~'%20.jpg", // Image from assets
			"drawable://" + R.mipmap.touxiang, // Image from drawables
			"http://upload.wikimedia.org/wikipedia/ru/b/b6/Как_кот_с_мышами_воевал.png", // Link with UTF-8
			"https://www.eff.org/sites/default/files/chrome150_0.jpg", // Image from HTTPS
			"http://bit.ly/soBiXr", // Redirect link
			"http://img001.us.expono.com/100001/100001-1bc30-2d736f_m.jpg", // EXIF
			"", // Empty link
			"http://wrong.site.com/corruptedLink", // Wrong link
	};

	private Constants() {
	}

	public static class Config {
		public static final boolean DEVELOPER_MODE = false;
	}
	
	public static class Extra {
		public static final String FRAGMENT_INDEX = "com.nostra13.example.universalimageloader.FRAGMENT_INDEX";
		public static final String IMAGE_POSITION = "com.nostra13.example.universalimageloader.IMAGE_POSITION";
	}
}
