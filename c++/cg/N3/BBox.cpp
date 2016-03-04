#include "BBox.hpp"

#include "Ponto.hpp"

#include <vector>

Ponto BBox::centro() const {

	double x = (min.x + max.x) / 2;
	double y = (min.y + max.y) / 2;

	return Ponto(x, y);
}

void BBox::redesenha(const vector<Ponto>& pontos) {
	min = pontos.front();
	max = pontos.front();

	for (auto it = begin(pontos); it != end(pontos); ++it) {
		min.x = std::min(min.x, it->x);
		min.y = std::min(min.y, it->y);

		max.x = std::max(max.x, it->x);
		max.y = std::max(max.y, it->y);
	}
}

bool BBox::contem(const Ponto& point) const {
	return point.x >= min.x && point.x <= max.x
			&& point.y >= min.y && point.y <= max.y;
}

bool operator == (const BBox& lhs, const BBox& rhs) {
	return lhs.min == rhs.min && lhs.max == rhs.max;
}

