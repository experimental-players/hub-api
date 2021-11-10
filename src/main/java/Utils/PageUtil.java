package Utils;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageUtil implements Pageable {

    private int limit;
    private int offset;
    private Sort sort= Sort.unsorted(); //new Sort(Sort.Direction.DESC, "idProdotto");

/*
        DA RIVEDERE, NON PRENDE IL SORT

    public PageUtil(int limit, int page, String order, String direction) {
        super();
        this.limit = limit > 100? 100:limit;

        if (page <= 0) {
            page = 0;
        } else {
            page = limit * (page - 1);
        }
        this.offset = page;

        this.sort = direction.toUpperCase().compareTo("ASC") == 0 ? new Sort(Sort.Direction.DESC, order)
                : new Sort(Sort.Direction.ASC, order);
    }
*/
    public PageUtil(int limit, int page) {
        if (limit < 1) {
            throw new IllegalArgumentException("Limit must not be less than one!");
        }
        if (page <= 0) {
            page = 0;
        } else {
            page = limit * (page - 1);
        }
        this.limit = limit;
        this.offset = page;
    }

	public PageUtil(int limit, int page, Sort sort) {
		if (limit < 1) {
			throw new IllegalArgumentException("Limit must not be less than one!");
		}
		if (page <= 0) {
			page = 0;
		} else {
			page = limit * (page - 1);
		}
		this.limit = limit;
		this.offset = page;
		this.sort = sort;
	}

    @Override
    public int getPageNumber() {
        return offset / limit;
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
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        // Typecast possible because number of entries cannot be bigger than integer
        // (primary key is integer)
        return new PageUtil(getPageSize(), (int) (getOffset() + getPageSize()));
    }

    public Pageable previous() {
        // The integers are positive. Subtracting does not let them become bigger than
        // integer.
        return hasPrevious() ? new PageUtil(getPageSize(), (int) (getOffset() - getPageSize())) : this;
    }

    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    @Override
    public Pageable first() {
        return new PageUtil(0, getPageSize());
    }

    @Override
    public Pageable withPage(int i) {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return offset > limit;
    }

}
