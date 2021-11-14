package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 여기서는 동시성 문제가 고려되지 않아. 그렇기에 실무에서는 HashMap이 아닌 ConcurrentHashMap, AtomicLong 사용을 고려해야한다.
 */

public class MemberRepository {

    private Map<Long, Member> stores = new HashMap<>();
    private long sequence = 0L;


    /**
     * 아래 싱글톤으로 설계한거임. 싱글톤 공부할 때 참고
     */

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository(){
    }
    /* 여기까지 */

    public  Member save(Member member){
        member.setId(++sequence);
        stores.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return stores.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(stores.values());
    }

    public void clearStore(){
        stores.clear();
    }
}

