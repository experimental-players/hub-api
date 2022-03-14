package Utils;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class PageUtil implements Pageable {

	private final int limit;
	private final int offset;
	private final Sort sort;

	public PageUtil(int limit, int page, String orderColumn, Direction direction) {
		this(limit, page, Sort.by(direction, orderColumn));
	}

	public PageUtil(int limit, int page) {
		this(limit, page, Sort.unsorted());
	}

	public PageUtil(int limit, int page, Sort sort) {

		this.limit = Math.min(limit, 100);
		this.sort = sort;

		if (limit < 1)
			throw new IllegalArgumentException("Limit must not be less than one!");

		offset = (page > 0) ? this.limit * (page - 1) : 0;

	}

	@Override
	public int getPageNumber() {
		return (offset / limit) + 1;
	}

	@Override
	public int getPageSize() {
		return limit;
	}

	@Override
	public long getOffset() {
		return offset;
	}

	@Override
	public @NotNull Sort getSort() {
		return sort;
	}

	@Override
	public @NotNull Pageable next() {
		return new PageUtil(limit, getPageSize() + 1);
	}

	@Override
	public @NotNull Pageable previousOrFirst() {
		return hasPrevious() ? new PageUtil(limit, getPageNumber() - 1) : this;
	}

	@Override
	public @NotNull Pageable first() {
		return new PageUtil(limit, 1);
	}

	@Override
	public @NotNull Pageable withPage(int page) {
		return new PageUtil(limit, page, sort);
	}

	@Override
	public boolean hasPrevious() {
		return offset >= limit;
	}

}
