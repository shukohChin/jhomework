package ch21.ex21_05;

import java.util.AbstractList;

public class ArrayBunchList<E> extends AbstractList<E> {
	private final E[][] arrays;
	private final int size;


	public ArrayBunchList(final E[][] arrays) {
		this.arrays = arrays.clone();
		int s = 0;
		for (final E[] array : arrays) {
			s += array.length;
		}
		this.size = s;
	}


	@Override
	public int size() {
		// TODO 自動生成されたメソッド・スタブ
		return this.size;
	}


	@Override
	public E get(int index) {
		// TODO 自動生成されたメソッド・スタブ
		int off = 0;
		for (int i = 0; i < this.arrays.length; i++) {
			if (index < off + this.arrays[i].length) {
				return this.arrays[i][index - off];
			}
			off += this.arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}


	@Override
	public E set(final int index, final E value) {
		int off = 0;
		for (int i = 0; i < this.arrays.length; i++) {
			if (index < off + this.arrays[i].length) {
				final E ret = this.arrays[i][index - off];
				this.arrays[i][index - off] = value;
				return ret;
			}
			off += this.arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

}
