package challenges.reverse;

import java.util.*;

import challenges.*;

import net.jqwik.api.*;
import net.jqwik.api.lifecycle.*;

import static org.assertj.core.api.Assertions.*;

@Label("Reverse")
@AddLifecycleHook(CountEvaluations.class)
class ReverseProperties {

	@Property(afterFailure = AfterFailureMode.RANDOM_SEED)
	void test(@ForAll List<Integer> ls) {
		assertThat(reversed(ls)).isEqualTo(ls);
	}

	private List<Integer> reversed(final List<Integer> ls) {
		ArrayList<Integer> reversed = new ArrayList<>(ls);
		Collections.reverse(reversed);
		return reversed;
	}
}

// @eval_given(st.lists(st.integers()))
// def test(ls):
// 					rev = list(reversed(ls))
// 					assert ls == rev