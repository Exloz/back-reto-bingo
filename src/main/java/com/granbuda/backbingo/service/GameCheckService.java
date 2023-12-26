package com.granbuda.backbingo.service;

import com.granbuda.backbingo.model.Cell;
import com.granbuda.backbingo.model.GameSet;
import com.granbuda.backbingo.repository.GameSetRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameCheckService {
    private final GameSetRepository repository;

    public GameCheckService(GameSetRepository repository) {
        this.repository = repository;
    }

    public boolean checkWinner(List<Cell> cellList) {
        GameSet activeGameSet = repository.findByIsActiveGameTrue();
        List<Integer> generatedBalls = activeGameSet.getBallots();

        return checkAllCellsExceptThirteen(cellList, generatedBalls) ||
                checkSpecificCells(new int[]{5, 9, 17, 21}, cellList, generatedBalls) ||
                checkSpecificCells(new int[]{1, 7, 19, 25}, cellList, generatedBalls) ||
                checkRangeOfCells(new int[]{1, 5}, cellList, generatedBalls) ||
                checkRangeOfCells(new int[]{6, 10}, cellList, generatedBalls) ||
                checkRangeOfCellsExcluding(new int[]{11, 15}, 13, cellList, generatedBalls) ||
                checkRangeOfCells(new int[]{16, 20}, cellList, generatedBalls) ||
                checkRangeOfCells(new int[]{21, 25}, cellList, generatedBalls) ||
                checkCornersAndCenter(cellList, generatedBalls) ||
                checkHorizontalLines(new int[]{1, 21}, cellList, generatedBalls) ||
                checkHorizontalLines(new int[]{2, 22}, cellList, generatedBalls) ||
                checkHorizontalLinesExcluding(new int[]{3, 23}, new int[]{13}, cellList, generatedBalls) ||
                checkHorizontalLines(new int[]{4, 24}, cellList, generatedBalls) ||
                checkSpecialPattern(new int[]{5, 10, 12, 20, 25}, cellList, generatedBalls);
    }

    private boolean checkAllCellsExceptThirteen(List<Cell> cellList, List<Integer> generatedBalls) {
        for (int i = 1; i <= 25; i++) {
            if (i != 13 && !isCellMarked(i, cellList, generatedBalls)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSpecificCells(int[] specificCells, List<Cell> cellList, List<Integer> generatedBalls) {
        for (int cellCoordinate : specificCells) {
            if (!isCellMarked(cellCoordinate, cellList, generatedBalls)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRangeOfCells(int[] range, List<Cell> cellList, List<Integer> generatedBalls) {
        for (int i = range[0]; i <= range[1]; i++) {
            if (!isCellMarked(i, cellList, generatedBalls)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRangeOfCellsExcluding(int[] range, int exclude, List<Cell> cellList, List<Integer> generatedBalls) {
        for (int i = range[0]; i <= range[1]; i++) {
            if (i != exclude && !isCellMarked(i, cellList, generatedBalls)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCornersAndCenter(List<Cell> cellList, List<Integer> generatedBalls) {
        int[] cornersAndCenter = {1, 5, 21, 25, 13};
        return checkSpecificCells(cornersAndCenter, cellList, generatedBalls);
    }

    private boolean checkHorizontalLines(int[] range, List<Cell> cellList, List<Integer> generatedBalls) {
        for (int i = range[0]; i <= range[1]; i += 5) {
            if (!isCellMarked(i, cellList, generatedBalls)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkHorizontalLinesExcluding(int[] range, int[] excludes, List<Cell> cellList, List<Integer> generatedBalls) {
        for (int i = range[0]; i <= range[1]; i += 5) {
            boolean isExcluded = false;
            for (int exclude : excludes) {
                if (i == exclude) {
                    isExcluded = true;
                    break;
                }
            }
            if (!isExcluded && !isCellMarked(i, cellList, generatedBalls)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSpecialPattern(int[] coordinates, List<Cell> cellList, List<Integer> generatedBalls) {
        return checkSpecificCells(coordinates, cellList, generatedBalls);
    }

    private boolean isCellMarked(int coordinate, List<Cell> cellList, List<Integer> generatedBalls) {
        return cellList.stream()
                .anyMatch(cell -> cell.getCoordinate() == coordinate && generatedBalls.contains(cell.getNumber()));
    }
}
